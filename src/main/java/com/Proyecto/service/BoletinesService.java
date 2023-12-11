/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.service;
 
import com.Proyecto.domain.Boletines;
import java.util.List;

// Esta interface es para obtener el listado de boletiness
public interface BoletinesService {
   
    // Se obtiene un listado de boletiness en un List
    public List<Boletines> getBoletines(boolean activos);
    
   // Se obtiene un Boletines, a partir del id de un boletines
    public Boletines getBoletines(Boletines boletines);
    
    // Se inserta un nuevo boletines si el id del boletines esta vacío
    // Se actualiza un boletines si el id del boletines NO esta vacío
    public void save(Boletines boletines);
    
    // Se elimina el boletines que tiene el id pasado por parámetro
    public void delete(Boletines boletines);
    
}
