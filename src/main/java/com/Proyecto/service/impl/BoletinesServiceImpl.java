/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.service.impl;

import com.Proyecto.dao.BoletinesDao;
import com.Proyecto.domain.Boletines;
import com.Proyecto.service.BoletinesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

// Se le indica una anotación que esta clase es un servicio
@Service
// debe implementar la interface BoletinesService, hacer click derecho y seleccionar 
// implements all abstract methods
public class BoletinesServiceImpl implements BoletinesService{

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired 
    private BoletinesDao boletinesDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Boletines> getBoletines(boolean activo) {
        var boletines = boletinesDao.findAll();
        return boletines;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Boletines getBoletines(Boletines boletines) {
        return boletinesDao.findById(boletines.getIdBoletin()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Boletines boletines) {
        boletinesDao.save(boletines);
    }

    @Override
    @Transactional
    public void delete(Boletines boletines) {
        boletinesDao.delete(boletines);
    }
    
}
