/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Proyecto.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

// Esta interface es para obtener el listado de usuarioss
public interface UsuariosDetailsService {
   
    public UserDetails loadUserByNombre(String nombre) throws  
            UsernameNotFoundException;
}
