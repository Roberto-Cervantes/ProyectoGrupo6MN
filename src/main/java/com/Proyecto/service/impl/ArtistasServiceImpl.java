/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.service.impl;

import com.Proyecto.dao.ArtistasDao;
import com.Proyecto.domain.Artistas;
import com.Proyecto.service.ArtistasService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional;

// Se le indica una anotación que esta clase es un servicio
@Service
// debe implementar la interface ArtistasService, hacer click derecho y seleccionar 
// implements all abstract methods
public class ArtistasServiceImpl implements ArtistasService{

    // permite implementar un objeto sin tener que hacer new y con solo una instancia de él
    @Autowired 
    private ArtistasDao artistasDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Artistas> getArtistas(boolean activo) {
        var artistas = artistasDao.findAll();
        return artistas;
    }
    
    @Override
    @Transactional(readOnly = true)
    public Artistas getArtistas(Artistas artistas) {
        return artistasDao.findById(artistas.getIdArtista()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Artistas artistas) {
        artistasDao.save(artistas);
    }

    @Override
    @Transactional
    public void delete(Artistas artistas) {
        artistasDao.delete(artistas);
    }
    
}
