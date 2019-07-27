package me.liluyang.jpa.repository;

import me.liluyang.jpa.dto.*;
import me.liluyang.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, String> {

    UserDto findClassById(String id);

    // 查询效率极高，查什么字段返回什么字段，而且只进行一次条件查询，但是如果要关联查询数组之类的数据，就是要查询多次
    @Query("SELECT new me.liluyang.jpa.dto.UserDto2(u.id, u.username, u.gender, u.address.id, u.address.location) FROM User u WHERE u.id = :id")
    UserDto2 findClass2ById(@Param("id") String id);

    UserView findViewById(String id);

    UserView2 findView2ById(String id);

    UserView3 findView3ById(String id);

    <T> T findByUsername(String username, Class<T> type);
}
