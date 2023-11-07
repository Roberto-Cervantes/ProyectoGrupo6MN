package com.Proyecto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// se le indica que es una clase @Controller
@Controller
// esto indica que es un mapeo de consultas
// "/usuarios" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
@RequestMapping("/administrador")

public class ControlController {


    //Esto es un mapeo de un metodo GET (no de consultas como el de arriba)
    // "/listado" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
    @GetMapping("/control")
    public String listado() {
        return "administrador/control";
    }

}
