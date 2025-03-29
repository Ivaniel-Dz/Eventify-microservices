package com.microservice.usuarios.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.microservice.usuarios.dto.LoginDto;
import com.microservice.usuarios.dto.RegisterDto;
import com.microservice.usuarios.services.AuthService;

import javax.validation.Valid;

// @Valid: Anotación que se utiliza para validar los campos de un objeto
// @RequestBody: Anotación que se utiliza para indicar que el método espera un objeto en formato JSON
// BindingResult: Interfaz que representa el resultado de la validación de un objeto
// ResponseEntity: Clase que representa una respuesta HTTP
@RestController
@RequestMapping("/auth")
public class AuthController {
    // Inyección de dependencias
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginDto loginDto, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("{\"error\": \"Revise sus credenciales\"}"); //devuelve mensaje de error en json
        }
        try {
            String jwt = authService.authenticate(loginDto.getEmail(), loginDto.getPassword());
            return ResponseEntity.ok().body("{\"token\": \"" + jwt + "\"}"); //devuelve token en formato json
            // return ResponseEntity.ok(jwt);   //devuelve token en formato texto plano (string)
        } catch (Exception e){
            return ResponseEntity.badRequest().body("{\"error\": \"" + e.getMessage() + "\"}"); //devuelve mensaje de error en json
        }
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@Valid @RequestBody RegisterDto registerDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResponseEntity.badRequest().body("Revise los campos"); //devuelve mensaje de error en string
        }
        try {
            authService.registerUser(registerDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Registrado");
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage()); //devuelve mensaje de error en string
        }
    }

    // Verification de acceso sin Role
    @GetMapping("/check-auth")
    public ResponseEntity<String> checkAuth(){
        return ResponseEntity.ok().body("Autenticado"); //devuelve mensaje de error en string
    }
}
