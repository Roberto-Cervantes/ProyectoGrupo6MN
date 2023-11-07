package com.Proyecto.controller;

import com.Proyecto.domain.Eventos;
import com.Proyecto.service.EventosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// se le indica que es una clase @Controller
@Controller
// esto indica que es un mapeo de consultas
// "/eventos" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
@RequestMapping("/eventos")

public class EventosController {

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired

    private EventosService eventosService;

    //Esto es un mapeo de un metodo GET (no de consultas como el de arriba)
    // "/listado" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
    @GetMapping("/listado")
    public String listado() {
        return "eventos/listado";
    }

    @GetMapping("/crearEventos")
    public String eventosNuevo(Eventos eventos) {
        return "/eventos/crearEventos";
    }


    @PostMapping("/guardar")
    public String eventosGuardar(Eventos eventos) {
        System.out.println("****45****"+eventos+"****45****");
        eventosService.save(eventos);
        return "redirect:/eventos/crearUsuario";
    }

    @GetMapping("/eliminar/{idEventos}")
    public String eventosEliminar(Eventos eventos) {
        eventosService.delete(eventos);
        return "redirect:/eventos/listado";
    }

    @GetMapping("/modificar/{idEventos}")
    public String eventosModificar(Eventos eventos, Model model) {
        eventos = eventosService.getEventos(eventos);
        model.addAttribute("eventos", eventos);
        return "/eventos/modifica";
    }

}
