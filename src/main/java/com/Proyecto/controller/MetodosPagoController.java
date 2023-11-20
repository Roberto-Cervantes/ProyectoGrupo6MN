package com.Proyecto.controller;
import org.springframework.stereotype.Controller;
import com.Proyecto.domain.Artistas;
import com.Proyecto.domain.MetodoPago;
import com.Proyecto.service.MetodoPagoService;
import com.Proyecto.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
@RequestMapping("/metodosPago")
public class MetodosPagoController {

    @Autowired
    private MetodoPagoService metodoPagoService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var metodos = metodoPagoService.listarMetodosPago(); // Corregido aquí
        model.addAttribute("metodosPago", metodos);
        model.addAttribute("totalMetodosPago", metodos.size());
        return "metodosPago/listado";
    }

    @GetMapping("/crear")
    public String crearMetodoPago(MetodoPago metodoPago) {
        return "metodosPago/crear";
    }

    @PostMapping("/guardar")
    public String guardarMetodoPago(MetodoPago metodoPago) {
        metodoPagoService.guardarMetodoPago(metodoPago); // Corregido aquí
        return "redirect:/metodosPago/listado";
    }

    @GetMapping("/eliminar/{idMetodoPago}")
    public String eliminarMetodoPago(@PathVariable("idMetodoPago") MetodoPago metodoPago) {
        metodoPagoService.eliminarMetodoPago(metodoPago); // Corregido aquí
        return "redirect:/metodosPago/listado";
    }

    @GetMapping("/modificar/{idMetodoPago}")
    public String modificarMetodoPago(@PathVariable("idMetodoPago") MetodoPago metodoPago, Model model) {
        metodoPago = metodoPagoService.encontrarMetodoPago(metodoPago);
        model.addAttribute("metodoPago", metodoPago);
        return "metodosPago/modificar";
    }
}
