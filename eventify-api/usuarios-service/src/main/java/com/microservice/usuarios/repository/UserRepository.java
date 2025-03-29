package com.microservice.usuarios.repository;

import com.microservice.usuarios.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Buscar un usuario por su email
    Optional<User> findByEmail(String email);
    // Verificar si el email ya está registrado
    boolean existsByEmail(String email);
    // Verificar si existe un usuario con el nombre de usuario dado
    boolean existsByUsername(String username);
}
