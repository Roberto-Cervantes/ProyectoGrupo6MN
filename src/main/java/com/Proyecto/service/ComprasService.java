/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.service;

import com.Proyecto.domain.Compras; 
import java.util.List;

// Esta interface es para obtener el listado de comprass
public interface ComprasService {
   
    // Se obtiene un listado de comprass en un List
    public List<Compras> getCompras(boolean activos);
    
   // Se obtiene un Compras, a partir del id de un compras
    public Compras getCompras(Compras compras);
    
    // Se inserta un nuevo compras si el id del compras esta vacío
    // Se actualiza un compras si el id del compras NO esta vacío
    public void save(Compras compras);
    
}
