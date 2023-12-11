/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.service.impl; 

import com.Proyecto.dao.NotificacionesDao;
import com.Proyecto.domain.Notificaciones;
import com.Proyecto.service.NotificacionesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Se le indica una anotación que esta clase es un servicio
@Service
// debe implementar la interface NotificacionesService, hacer click derecho y seleccionar 
// implements all abstract methods
public class NotificacionesServiceImpl implements NotificacionesService{

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired 
    private NotificacionesDao notificacionesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Notificaciones> getNotificaciones(boolean activo) {
        var notificaciones = notificacionesDao.findAll();
        return notificaciones;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Notificaciones getNotificaciones(Notificaciones notificaciones) {
        return notificacionesDao.findById(notificaciones.getIdNotificacion()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Notificaciones notificaciones) {
        notificacionesDao.save(notificaciones);
    }

    @Override
    @Transactional
    public void delete(Notificaciones notificaciones) {
        notificacionesDao.delete(notificaciones);
    }
    
}
