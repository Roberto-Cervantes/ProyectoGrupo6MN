package com.Proyecto.controller;

import com.Proyecto.domain.Eventos;
import com.Proyecto.service.EventosService;
import com.Proyecto.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile; 

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
    public String listado (Model model){
        // con la variable false, se pretende que devuelva solo todas las eventos
        //  si se lecciona true, solo va a devolver las activas
        var  eventos = eventosService.getEventos(false);
        
        //se va a incorporar el arraylist para que pueda ser vista por una pagina HTML
        // "Eventoss" es nombre de una variable 
        //eventos hace referencia a la variable indicada en var
        model.addAttribute("eventos", eventos);
        model.addAttribute("totalEventos", eventos.size());
        
        //el return devuelve una ubicación de un archivo
        // eventos es una carpeta, listado es un archivo
        // Esta carpeta fue creada en el paquete templates de main/resources
        
        return "eventos/listado";
    }
   

    @GetMapping("/crearEventos")
    public String eventosNuevo(Eventos eventos) {
        return "/eventos/crearEventos";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String eventosGuardar(Eventos eventos,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        
        if (!imagenFile.isEmpty()) {
            eventosService.save(eventos);
            eventos.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "eventos",
                            eventos.getIdEvento()));
        }
        System.out.println("******"+eventos+"******");
        System.out.println("******"+imagenFile+"******");
        eventosService.save(eventos);
        return "redirect:/eventos/listado";
    }

    @GetMapping("/elimina/{idEvento}")
    public String eventosEliminar(Eventos eventos) {
        System.out.println("***77***"+eventos+"***77***");
        eventosService.delete(eventos);
        return "redirect:/eventos/listado";
    }

    @GetMapping("/modifica/{idEvento}")
    public String eventosModificar(Eventos eventos, Model model) {
        eventos = eventosService.getEventos(eventos);
        model.addAttribute("eventos", eventos);
        System.out.println("***86***"+eventos+"***86***");
        return "eventos/modifica";
    }

}
