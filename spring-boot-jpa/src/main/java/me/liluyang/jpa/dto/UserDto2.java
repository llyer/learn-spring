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
public class UserDto2 {

    private String id;

    private String username;

    private String gender;

    private Address address;

    public UserDto2(String id, String username, String gender, String AddressId, String AddressLocation) {
        this.id = id;
        this.username = username;
        this.gender = gender;
        this.address = new Address(AddressId, AddressLocation);
    }

    @Data
    @AllArgsConstructor
    class Address {
        private String id;

        private String location;
    }
}
