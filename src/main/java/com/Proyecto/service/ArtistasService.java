/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.service;

import com.Proyecto.domain.Artistas; 
import java.util.List;

// Esta interface es para obtener el listado de artistass
public interface ArtistasService {
   
    // Se obtiene un listado de artistass en un List
    public List<Artistas> getArtistas(boolean activos);
    
   // Se obtiene un Artistas, a partir del id de un artistas
    public Artistas getArtistas(Artistas artistas);
    
    // Se inserta un nuevo artistas si el id del artistas esta vacío
    // Se actualiza un artistas si el id del artistas NO esta vacío
    public void save(Artistas artistas);
    
    // Se elimina el artistas que tiene el id pasado por parámetro
    public void delete(Artistas artistas);
    
}
