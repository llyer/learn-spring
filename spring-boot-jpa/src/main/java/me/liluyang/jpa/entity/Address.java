package me.liluyang.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * 实体类Demo
 */
@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    private String id;

    private String location;

    private String remark;

    @JsonIgnoreProperties(value = {"address", "roles"})
    @OneToOne(mappedBy = "address")
    private User user;

    public Address(String id, String location) {
        this.id = id;
        this.location = location;
    }
}
