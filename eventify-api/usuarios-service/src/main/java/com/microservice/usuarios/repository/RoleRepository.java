package com.microservice.usuarios.repository;

import com.microservice.usuarios.enums.RoleList;
import com.microservice.usuarios.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    // Busca el tipo de role del usuario
    Optional<Role> findByRole(RoleList role);

}
