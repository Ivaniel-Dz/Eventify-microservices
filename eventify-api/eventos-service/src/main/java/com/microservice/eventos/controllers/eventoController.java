package com.microservice.eventos.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eventos")
public class eventoController {

    @GetMapping("/test")
    public String healthCheck() {
        return "¡Ruta /eventos/test funciona a través del Gateway!";
    }
}
