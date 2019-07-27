package me.liluyang.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 使用 dto class 效率很高，要什么数据，查询什么数据
 *
 * 基础数据查询效率非常高
 *
 */
@Data
@AllArgsConstructor
public class UserDto {

    private String id;

    private String username;

    private String gender;

    // 如果取消注释，可以正常的关联查询到实体类。正常，但是没有意义
//    private Address address;

    // 报错
//    private AddressDto address;
}
