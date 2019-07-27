package me.liluyang.mybatis.generator;

import java.util.List;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> getAll();

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getOne(Long id);

    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}