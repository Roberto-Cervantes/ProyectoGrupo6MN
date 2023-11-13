package com.Proyecto.controller;

import com.Proyecto.domain.Notificaciones;
import com.Proyecto.service.NotificacionesService;
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
// "/notificaciones" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
@RequestMapping("/notificaciones")

public class NotificacionesController {

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired
    private NotificacionesService notificacionesService;
    
    //Esto es un mapeo de un metodo GET (no de consultas como el de arriba)
    // "/listado" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
    @GetMapping("/listado")
    public String listado (Model model){
        // con la variable false, se pretende que devuelva solo todas las notificaciones
        //  si se lecciona true, solo va a devolver las activas
        var  notificaciones = notificacionesService.getNotificaciones(false);
        
        //se va a incorporar el arraylist para que pueda ser vista por una pagina HTML
        // "Notificacioness" es nombre de una variable 
        //notificaciones hace referencia a la variable indicada en var
        model.addAttribute("notificaciones", notificaciones);
        model.addAttribute("totalNotificaciones", notificaciones.size());
        
        //el return devuelve una ubicación de un archivo
        // notificaciones es una carpeta, listado es un archivo
        // Esta carpeta fue creada en el paquete templates de main/resources
        
        return "notificaciones/listado";
    }
   

    @GetMapping("/crearNotificaciones")
    public String notificacionesNuevo(Notificaciones notificaciones) {
        return "/notificaciones/crearNotificaciones";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String notificacionesGuardar(Notificaciones notificaciones) {
        System.out.println("*****59*****"+notificaciones+"*****59*****");
        notificacionesService.save(notificaciones);
        return "redirect:/notificaciones/listado";
    }

    @GetMapping("/elimina/{idNotificacion}")
    public String notificacionesEliminar(Notificaciones notificaciones) {
        System.out.println("***66***"+notificaciones+"***66***");
        notificacionesService.delete(notificaciones);
        return "redirect:/notificaciones/listado";
    }

    @GetMapping("/modifica/{idNotificacion}")
    public String notificacionesModificar(Notificaciones notificaciones, Model model) {
        notificaciones = notificacionesService.getNotificaciones(notificaciones);
        model.addAttribute("notificaciones", notificaciones);
        System.out.println("***75***"+notificaciones+"***75***");
        return "notificaciones/modifica";
    }

}
