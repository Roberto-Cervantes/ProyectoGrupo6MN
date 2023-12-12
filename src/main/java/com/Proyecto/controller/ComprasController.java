package com.Proyecto.controller;

import com.Proyecto.domain.Compras;
import com.Proyecto.domain.Eventos;
import com.Proyecto.domain.Secciones;
import com.Proyecto.domain.Usuarios;
import com.Proyecto.service.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


// se le indica que es una clase @Controller
@Controller
// esto indica que es un mapeo de consultas
// "/compras" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
@RequestMapping("/compras")

public class ComprasController {

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired
    private ComprasService comprasService;
    
    //Esto es un mapeo de un metodo GET (no de consultas como el de arriba)
    // "/listado" es el nombre del get que aparece en la pagina web al pasar por encima el mouse
    @GetMapping("/listado")
    public String listado (Model model){
        // con la variable false, se pretende que devuelva solo todas las compras
        //  si se lecciona true, solo va a devolver las activas
        var  compras = comprasService.getCompras(false);
        
        //se va a incorporar el arraylist para que pueda ser vista por una pagina HTML
        // "Comprass" es nombre de una variable 
        //compras hace referencia a la variable indicada en var
        model.addAttribute("compras", compras);
        
        //el return devuelve una ubicación de un archivo
        // compras es una carpeta, listado es un archivo
        // Esta carpeta fue creada en el paquete templates de main/resources
        
        return "compras/listado";
    }
    
    
    @GetMapping("/crearCompras")
    public String comprasNuevo(Compras compras) {
    return "/compras/crearCompras";
    }
    
    @PostMapping("/guardar")
    public String comprasGuardar(Compras compras) {
        
        Eventos evento=new Eventos();
        evento.setIdEvento(1L);
        Secciones seccion=new Secciones();
        seccion.setIdSeccion(1L);
        Usuarios usuario=new Usuarios();
        usuario.setIdUsuarios(1L);
        
        //compras.setIdCompra(1L);
        compras.setEventos(evento);
        compras.setSecciones(seccion);
        compras.setUsuarios(usuario);
        
        System.out.println("******"+compras.getIdCompra()+"**********");
        
        comprasService.save(compras);
        return "redirect:/compras/listado";
    }

}
