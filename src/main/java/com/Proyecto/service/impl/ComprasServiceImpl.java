/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.service.impl;

import com.Proyecto.dao.ComprasDao;
import com.Proyecto.domain.Compras;
import com.Proyecto.service.ComprasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; 

// Se le indica una anotación que esta clase es un servicio
@Service
// debe implementar la interface ComprasService, hacer click derecho y seleccionar 
// implements all abstract methods
public class ComprasServiceImpl implements ComprasService{

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired 
    private ComprasDao comprasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Compras> getCompras(boolean activo) {
        var compras = comprasDao.findAll();
        return compras;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Compras getCompras(Compras compras) {
        return comprasDao.findById(compras.getIdCompra()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Compras compras) {
        comprasDao.save(compras);
    }
    
}
