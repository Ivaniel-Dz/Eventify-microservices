package com.microservice.usuarios.models;

import com.microservice.usuarios.enums.RoleList;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Genera automáticamente los métodos estándar de una clase, evitando código repetitivo.
@NoArgsConstructor // Genera un constructor sin argumentos.
@AllArgsConstructor // Genera un constructor con todos los campos de la clase como argumentos.
@Entity // Indica que la clase es una entidad persistente y se mapea a una tabla en la base de datos.
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private RoleList name;
}
