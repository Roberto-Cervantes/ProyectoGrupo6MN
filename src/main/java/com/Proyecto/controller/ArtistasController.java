package com.Proyecto.controller;

import com.Proyecto.domain.Artistas;
import com.Proyecto.service.ArtistasService;
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
// "/artistas" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
@RequestMapping("/artistas")

public class ArtistasController {

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired
    private ArtistasService artistasService;
    
    //Esto es un mapeo de un metodo GET (no de consultas como el de arriba)
    // "/listado" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
    @GetMapping("/listado")
    public String listado (Model model){
        // con la variable false, se pretende que devuelva solo todas las artistas
        //  si se lecciona true, solo va a devolver las activas
        var  artistas = artistasService.getArtistas(false);
        
        //se va a incorporar el arraylist para que pueda ser vista por una pagina HTML
        // "Artistass" es nombre de una variable 
        //artistas hace referencia a la variable indicada en var
        model.addAttribute("artistas", artistas);
        model.addAttribute("totalArtistas", artistas.size());
        
        //el return devuelve una ubicación de un archivo
        // artistas es una carpeta, listado es un archivo
        // Esta carpeta fue creada en el paquete templates de main/resources
        
        return "artistas/listado";
    }
   

    @GetMapping("/crearArtistas")
    public String artistasNuevo(Artistas artistas) {
        return "/artistas/crearArtistas";
    }
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String artistasGuardar(Artistas artistas,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        
        if (!imagenFile.isEmpty()) {
            artistasService.save(artistas);
            artistas.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "artistas",
                            artistas.getIdArtista()));
        }
        System.out.println("******"+artistas+"******");
        System.out.println("******"+imagenFile+"******");
        artistasService.save(artistas);
        return "redirect:/artistas/listado";
    }

    @GetMapping("/elimina/{idArtista}")
    public String artistasEliminar(Artistas artistas) {
        System.out.println("***77***"+artistas+"***77***");
        artistasService.delete(artistas);
        return "redirect:/artistas/listado";
    }

    @GetMapping("/modifica/{idArtista}")
    public String artistasModificar(Artistas artistas, Model model) {
        artistas = artistasService.getArtistas(artistas);
        model.addAttribute("artistas", artistas);
        System.out.println("***86***"+artistas+"***86***");
        return "artistas/modifica";
    }

}
