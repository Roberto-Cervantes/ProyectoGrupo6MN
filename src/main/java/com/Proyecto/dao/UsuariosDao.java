/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.dao;

import com.Proyecto.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

// esta interface debe de heredar de JpaRepository<Clase, tio dato>, eso es todo

public interface UsuariosDao extends JpaRepository<Usuarios, Long>{
    // se hace una busqueda por username
    Usuarios findByUsername(String username);
}
