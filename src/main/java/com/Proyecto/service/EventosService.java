/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.service;

import com.Proyecto.domain.Eventos; 
import java.util.List;

// Esta interface es para obtener el listado de eventoss
public interface EventosService {
   
    // Se obtiene un listado de eventoss en un List
    public List<Eventos> getEventos(boolean activos);
    
   // Se obtiene un Eventos, a partir del id de un eventos
    public Eventos getEventos(Eventos eventos);
    
    // Se inserta un nuevo eventos si el id del eventos esta vacío
    // Se actualiza un eventos si el id del eventos NO esta vacío
    public void save(Eventos eventos);
    
    // Se elimina el eventos que tiene el id pasado por parámetro
    public void delete(Eventos eventos);
    
}
