/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.service;

import com.Proyecto.domain.Notificaciones;
import java.util.List;

// Esta interface es para obtener el listado de notificacioness
public interface NotificacionesService {
   
    // Se obtiene un listado de notificacioness en un List
    public List<Notificaciones> getNotificaciones(boolean activos); 
    
   // Se obtiene un Notificaciones, a partir del id de un notificaciones
    public Notificaciones getNotificaciones(Notificaciones notificaciones);
    
    // Se inserta un nuevo notificaciones si el id del notificaciones esta vacío
    // Se actualiza un notificaciones si el id del notificaciones NO esta vacío
    public void save(Notificaciones notificaciones);
    
    // Se elimina el notificaciones que tiene el id pasado por parámetro
    public void delete(Notificaciones notificaciones);
    
}
