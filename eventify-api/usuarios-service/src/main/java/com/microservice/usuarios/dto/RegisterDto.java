package com.microservice.usuarios.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera automáticamente los métodos estándar de una clase, evitando código repetitivo.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los campos de la clase como argumentos.
public class RegisterDto {
    private String username;
    private String email;
    private String password;
}
