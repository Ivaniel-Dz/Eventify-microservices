package com.microservice.usuarios.services;

import com.microservice.usuarios.dto.RegisterDto;
import com.microservice.usuarios.enums.RoleList;
import com.microservice.usuarios.jwt.JwtUtil;
import com.microservice.usuarios.models.Role;
import com.microservice.usuarios.models.User;
import com.microservice.usuarios.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    // Inyección de dependencias
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    // Constructor
    @Autowired
    public AuthService(UserService userService, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil, AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    // Metodo Autenticar un usuario, generar un token y devolverlo
    public String authenticate(String email, String password){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

    // Metodo para Registrar un usuario
    public void registerUser(RegisterDto registerDto){
        if (userService.existsByUserName(registerDto.getUsername())){
            throw new IllegalArgumentException("El nombre de Usuario ya existe");
        }
        if (userService.existsByEmail(registerDto.getEmail())){
            throw new IllegalArgumentException("El Email de usario ya existe");
        }

        // Agregamos el role user al usuario
        Role role = roleRepository.findByRole(RoleList.ROLE_USER).orElseThrow(()-> new RuntimeException("Role no encontrado"));

        // Asignamos los datos ingresados al objeto
        User user = new User(
                registerDto.getUsername(),
                registerDto.getEmail(),
                passwordEncoder.encode(registerDto.getPassword()),
                role
        );
        //Guardamos los datos del usuario
        userService.save(user);
    }

}
