package com.Proyecto.controller;

import com.Proyecto.service.ReporteService;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reportes")
public class ReporteController {
    
    @Autowired
    private ReporteService reporteService;
    
    @GetMapping("/principal")
    public String listado(Model model) {
        Calendar fecha = Calendar.getInstance();
        String fechaIni = "" + (fecha.get(Calendar.YEAR) - 1) + "-01-01";
        String strMes = (fecha.get(Calendar.MONTH) < 10 ? "0" : "") + fecha.get(Calendar.MONTH);
        String strDia = (fecha.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "") + fecha.get(Calendar.DAY_OF_MONTH);
        String fechaFin = "" + fecha.get(Calendar.YEAR) + "-" + strMes + "-" + strDia;
        model.addAttribute("fechaInicio", fechaIni);
        model.addAttribute("fechaFin", fechaFin);
        return "/reportes/principal";
    }

    @GetMapping("/Artistas")
    public ResponseEntity<Resource> reporteArtistas(@RequestParam String tipo) 
            throws IOException {
        return reporteService.generaReporte("Artistas", null, tipo);
    }

    @GetMapping("/eventos")
    public ResponseEntity<Resource> reporteEventos(@RequestParam String tipo) 
            throws IOException {
        return reporteService.generaReporte("eventos", null, tipo);
    }

    @GetMapping("/eventosPorPeriodo")
    public ResponseEntity<Resource> reporteEventosPorPeriodo(
            @RequestParam String fechaIni,
            @RequestParam String fechaFin,
            @RequestParam String tipo) 
            throws IOException {
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("fechaIni", fechaIni);
        parametros.put("fechaFin", fechaFin);
        return reporteService.generaReporte("eventosPorPeriodo", parametros, tipo);
    }
    
    // Otros métodos existentes...
}
