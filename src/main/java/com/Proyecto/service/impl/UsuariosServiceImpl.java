/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.service.impl;

import com.Proyecto.dao.UsuariosDao;
import com.Proyecto.domain.Usuarios;
import com.Proyecto.service.UsuariosService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Se le indica una anotación que esta clase es un servicio
@Service
// debe implementar la interface UsuariosService, hacer click derecho y seleccionar 
// implements all abstract methods
public class UsuariosServiceImpl implements UsuariosService{

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired 
    private UsuariosDao usuariosDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Usuarios> getUsuarios(boolean activo) {
        var usuarios = usuariosDao.findAll();
        return usuarios;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Usuarios getUsuarios(Usuarios usuarios) {
        return usuariosDao.findById(usuarios.getIdUsuarios()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Usuarios usuarios) {
        usuariosDao.save(usuarios);
    }

    @Override
    @Transactional
    public void delete(Usuarios usuarios) {
        usuariosDao.delete(usuarios);
    }
    
}
