package com.microservice.usuarios.services;

import com.microservice.usuarios.models.User;
import com.microservice.usuarios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    // Constructor
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Cargar un usuario por su email, sobreescribiendo el método loadUserByUsername
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Buscar el usuario por su correo en la BD
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        // Crear una autoridad con el rol del usuario
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().getRole().toString());

        // Devolver un usuario de Spring Security
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singleton(authority) // Lista de autoridades (Roles)
        );
    }

    // Verificar si existe un usuario con el mismo Nombre
    public boolean existsByUserName(String username){
        return userRepository.existsByUsername(username);
    }

    // Verificar si existe un usuario con el mismo Email
    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    // Guardar un usuario
    public void save(User user){
        userRepository.save(user);
    }

}
