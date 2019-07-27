//package me.liluyang.mybatis.mapper;
//
//import me.liluyang.mybatis.entity.Role;
//import me.liluyang.mybatis.entity.User;
//import org.apache.ibatis.annotations.*;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Mapper
//@Component
//public interface RoleMapper {
//
//    @Select("SELECT * FROM role")
//    List<User> getAll();
//
//    @Select("SELECT * FROM role WHERE id = #{id}")
//    User getOne(Long id);
//
//    @Insert("INSERT INTO role(id,name) VALUES(#{id}, #{name})")
//    void insert(Role role);
//
//    /**
//     * 执行思路，找到最大的 id 并且在插入数据的时候自动将id + 1
//     *
//     * 正确的处理思路其实是获取自增 sequence 的方式 http://www.mybatis.org/mybatis-3/zh/java-api.html
//     *
//     * @param role
//     * @return
//     */
//    @Insert("insert into role(id,name) values(#{id}, #{name})")
//    @SelectKey(statement="SELECT id + 1 as id FROM role ORDER BY id desc limit 1", keyProperty="id", before=true, resultType=Long.class)
//    int insertByIncreasedKey(Role role);
//
//    @Update("UPDATE role SET name=#{name} WHERE id =#{id}")
//    void update(Role role);
//
//    @Delete("DELETE FROM role WHERE id =#{id}")
//    void delete(Long id);
//
//}