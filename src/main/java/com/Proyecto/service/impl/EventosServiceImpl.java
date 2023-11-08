/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.service.impl;

import com.Proyecto.dao.EventosDao;
import com.Proyecto.domain.Eventos;
import com.Proyecto.service.EventosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Se le indica una anotación que esta clase es un servicio
@Service
// debe implementar la interface EventosService, hacer click derecho y seleccionar 
// implements all abstract methods
public class EventosServiceImpl implements EventosService{

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired 
    private EventosDao eventosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Eventos> getEventos(boolean activo) {
        var eventos = eventosDao.findAll();
        return eventos;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Eventos getEventos(Eventos eventos) {
        return eventosDao.findById(eventos.getIdEvento()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Eventos eventos) {
        eventosDao.save(eventos);
    }

    @Override
    @Transactional
    public void delete(Eventos eventos) {
        eventosDao.delete(eventos);
    }
    
}
