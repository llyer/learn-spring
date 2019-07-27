package me.liluyang.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * 实体类Demo
 */
@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    private String id;

    private String name;

    @JsonIgnoreProperties(value = {"address", "roles"})
    @ManyToMany
    private List<User> users;

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
