package com.Proyecto.controller;

import com.Proyecto.domain.Usuarios;
import com.Proyecto.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// se le indica que es una clase @Controller
@Controller
// esto indica que es un mapeo de consultas
// "/usuarios" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
@RequestMapping("/usuarios")

public class UsuariosController {

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired

    private UsuariosService usuariosService;

    //Esto es un mapeo de un metodo GET (no de consultas como el de arriba)
    // "/listado" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
    @GetMapping("/crearUsuario")
    public String listado() {
        return "usuarios/crearUsuario";
    }

    @GetMapping("/nuevo")
    public String usuariosNuevo(Usuarios usuarios) {
        return "/usuarios/modifica";
    }


    @PostMapping("/guardar")
    public String usuariosGuardar(Usuarios usuarios) {
        System.out.println("****45****"+usuarios+"****45****");
        usuariosService.save(usuarios);
        return "redirect:/usuarios/crearUsuario";
    }

    @GetMapping("/eliminar/{idUsuarios}")
    public String usuariosEliminar(Usuarios usuarios) {
        usuariosService.delete(usuarios);
        return "redirect:/usuarios/listado";
    }

    @GetMapping("/modificar/{idUsuarios}")
    public String usuariosModificar(Usuarios usuarios, Model model) {
        usuarios = usuariosService.getUsuarios(usuarios);
        model.addAttribute("usuarios", usuarios);
        return "/usuarios/modifica";
    }

}
