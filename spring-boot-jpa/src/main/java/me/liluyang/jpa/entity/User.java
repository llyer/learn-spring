package me.liluyang.jpa.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 实体类Demo
 */
@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    private String id;

    private String username;

    private String password;

    private String gender;

    private Date lastLoginAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateAt;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createAt;

    @OneToOne
    private Address address;

    @JsonIgnoreProperties("users")
    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    public User(String id, String username) {
        this.id = id;
        this.username = username;
    }
}
