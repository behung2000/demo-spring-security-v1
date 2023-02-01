package com.demospringsecurityv1.springsecurity.repositories;

import com.demospringsecurityv1.springsecurity.models.Role;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EntityScan("com.demospringsecurityv1.springsecurity.models")
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
}
