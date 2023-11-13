package com.Proyecto.controller;

import com.Proyecto.domain.Boletines;
import com.Proyecto.service.BoletinesService;
import com.Proyecto.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



// se le indica que es una clase @Controller
@Controller
// esto indica que es un mapeo de consultas
// "/boletines" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
@RequestMapping("/boletines")

public class BoletinesController {

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired
    private BoletinesService boletinesService;
    
    //Esto es un mapeo de un metodo GET (no de consultas como el de arriba)
    // "/listado" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
    @GetMapping("/listado")
    public String listado (Model model){
        // con la variable false, se pretende que devuelva solo todas las boletines
        //  si se lecciona true, solo va a devolver las activas
        var  boletines = boletinesService.getBoletines(false);
        
        //se va a incorporar el arraylist para que pueda ser vista por una pagina HTML
        // "Boletiness" es nombre de una variable 
        //boletines hace referencia a la variable indicada en var
        model.addAttribute("boletines", boletines);
        model.addAttribute("totalBoletines", boletines.size());
        
        //el return devuelve una ubicación de un archivo
        // boletines es una carpeta, listado es un archivo
        // Esta carpeta fue creada en el paquete templates de main/resources
        
        return "boletines/listado";
    }
   

    @GetMapping("/crearBoletines")
    public String boletinesNuevo(Boletines boletines) {
        return "/boletines/crearBoletines";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String boletinesGuardar(Boletines boletines) {
        System.out.println("*****59*****"+boletines+"*****59*****");
        boletinesService.save(boletines);
        return "redirect:/boletines/listado";
    }

    @GetMapping("/elimina/{idBoletin}")
    public String boletinesEliminar(Boletines boletines) {
        System.out.println("***66***"+boletines+"***66***");
        boletinesService.delete(boletines);
        return "redirect:/boletines/listado";
    }

    @GetMapping("/modifica/{idBoletin}")
    public String boletinesModificar(Boletines boletines, Model model) {
        boletines = boletinesService.getBoletines(boletines);
        model.addAttribute("boletines", boletines);
        System.out.println("***75***"+boletines+"***75***");
        return "boletines/modifica";
    }

}
