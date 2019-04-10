package me.liluyang.springbootmybatis.mapper;

import me.liluyang.springbootmybatis.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    @Select("SELECT * FROM users")
    List<User> getAll();

    @Select("SELECT * FROM users WHERE id = #{id}")
    User getOne(Long id);

    @Insert("INSERT INTO users(id,username,password,gender) VALUES(#{id}, #{username}, #{password}, #{gender})")
    void insert(User user);

    /**
     * 执行思路，找到最大的 id 并且在插入数据的时候自动将id + 1
     *
     * 正确的处理思路其实是获取自增 sequence 的方式 http://www.mybatis.org/mybatis-3/zh/java-api.html
     *
     * @param user
     * @return
     */
    @Insert("insert into users(id,username,password,gender) values(#{id}, #{username}, #{password}, #{gender})")
    @SelectKey(statement="SELECT id + 1 as id FROM users ORDER BY id desc limit 1", keyProperty="id", before=true, resultType=Long.class)
    int insertByIncreasedKey(User user);

    @Update("UPDATE users SET username=#{username},password=#{password},gender=#{gender} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM users WHERE id =#{id}")
    void delete(Long id);

}