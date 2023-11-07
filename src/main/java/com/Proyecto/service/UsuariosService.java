/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.service;

import com.Proyecto.domain.Usuarios;
import java.util.List;

// Esta interface es para obtener el listado de usuarioss
public interface UsuariosService {
   
    // Se obtiene un listado de usuarioss en un List
    public List<Usuarios> getUsuarios(boolean activos);
    
   // Se obtiene un Usuarios, a partir del id de un usuarios
    public Usuarios getUsuarios(Usuarios usuarios);
    
    // Se inserta un nuevo usuarios si el id del usuarios esta vacío
    // Se actualiza un usuarios si el id del usuarios NO esta vacío
    public void save(Usuarios usuarios);
    
    // Se elimina el usuarios que tiene el id pasado por parámetro
    public void delete(Usuarios usuarios);
    
}
