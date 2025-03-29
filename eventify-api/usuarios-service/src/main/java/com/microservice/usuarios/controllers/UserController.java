package com.microservice.usuarios.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class UserController {

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String UserDashboard(){
        return "Bienvenido al panel de Usuario";
    }

    @GetMapping("/admin")
    public String AdminDashboard(){
        return "Bienvenido al panel de Administrator";
    }

}
