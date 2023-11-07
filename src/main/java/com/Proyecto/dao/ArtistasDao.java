/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.dao;

import com.Proyecto.domain.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;

// esta interface debe de heredar de JpaRepository<Clase, tio dato>, eso es todo

public interface ArtistasDao extends JpaRepository<Artistas, Long>{
    
}
