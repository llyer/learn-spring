package com.liluyang;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.PropertyWriter;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import lombok.Data;

import java.io.IOException;
import java.util.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonSerializationDeepFun {

    @Data
    @JsonFilter("depth_3")
    static class DynamicJsonObject {

        Long id;

        String name;

        BigDecimal price;

        List<DynamicJsonObject> children = new ArrayList<>();

        @JsonIgnore
        Map<String, Object> properties = new HashMap<>();

        @JsonAnySetter
        public void add(String key, String value) {
            properties.put(key, value);
        }

        @JsonAnyGetter
        public Map<String, Object> getMap() {
            return properties;
        }
    }


    /**
     * There're a couple of things to note when using this filter. <a href="https://stackoverflow.com/a/51279460/1961634">Visit stackoverflow for an example</a>
     * <ul>
     * <li>arrays provide an additional depth level, so array entry is depth+2
     * from parent; it's not a bug, it's a feature - this behavior could be
     * changed if JsonStreamContext is parsed for array start</li>
     * <li>map properties are serialized fully at the level the map is declared</li>
     * <li>depth is defined per-class; you could extend base class with DN suffix
     * to serialize if you need variable length, or make a constant filter name
     * and create a dedicated `ObjectMapper` for each depth</li>
     * </ul>
     * @author Dariusz Wawer <dwawer@pretius.com>
     *
     */
    static class DeepFieldFilter extends SimpleBeanPropertyFilter {

        private final int maxDepth;

        public DeepFieldFilter(int maxDepth) {
            super();
            this.maxDepth = maxDepth;
        }

        private int calcDepth(PropertyWriter writer, JsonGenerator jgen) {
            JsonStreamContext sc = jgen.getOutputContext();
            int depth = -1;
            while (sc != null) {
                sc = sc.getParent();
                depth++;
            }
            return depth;
        }

        /**
         * jackson 序列化设置
         *
         * @param pojo
         * @param gen
         * @param provider
         * @param writer
         * @throws Exception
         */
        @Override
        public void serializeAsField(Object pojo, JsonGenerator gen, SerializerProvider provider, PropertyWriter writer)
                throws Exception {
            int depth = calcDepth(writer, gen);
            if (depth <= maxDepth) {
                writer.serializeAsField(pojo, gen, provider);
            }
            // comment this if you don't want {} placeholders
            // 如果到了最大深度，就直接返回
            else {
//                writer.serializeAsOmittedField(pojo, gen, provider);
            }
        }

    }

    public static void main(String[] args) throws IOException {

        // 序列化工具
        ObjectMapper objectMapper = new ObjectMapper();

        SimpleFilterProvider depthFilters = new SimpleFilterProvider().addFilter("depth_1", new DeepFieldFilter(1))
                .addFilter("depth_2", new DeepFieldFilter(2))
                .addFilter("depth_3", new DeepFieldFilter(3))
//                .addFilter("depth_4", new DeepFieldFilter(4))
//                .addFilter("depth_5", new DeepFieldFilter(5))
                // ...
                ;

        // 设置深度过滤器
        objectMapper.setFilterProvider(depthFilters);

        //
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        DynamicJsonObject obj = new DynamicJsonObject();
        obj.setId(321L);
        obj.setName("name");
        obj.setPrice(BigDecimal.valueOf(10.0));

        Map<String, Object> mapD3 = new HashMap<>();
        mapD3.put("depth", "3");
        mapD3.put("info", "gets serialzied at depth 1");

        Map<String, Object> mapD2 = new HashMap<>();
        mapD2.put("depth", "2");
        mapD2.put("map", mapD3);

        Map<String, Object> mapD1 = new HashMap<>();
        mapD1.put("depth", "1");
        mapD1.put("map", mapD2);

        obj.setProperties(mapD1);

        DynamicJsonObject child = new DynamicJsonObject();
        child.setId(514L);
        child.setName("actually depth 3, because array");
        child.setPrice(BigDecimal.valueOf(5.1));
        obj.getChildren().add(child);

        String jsonStr = objectMapper.writeValueAsString(obj);
        System.out.println(jsonStr);
    }

}