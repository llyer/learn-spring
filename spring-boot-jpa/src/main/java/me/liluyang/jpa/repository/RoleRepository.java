package me.liluyang.jpa.repository;

import me.liluyang.jpa.dto.RoleDto;
import me.liluyang.jpa.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {

    RoleDto findOneById(String id);

}
