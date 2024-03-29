/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Proyecto.domain;

import jakarta.persistence.*;
import java.io.Serializable; 
import lombok.Data;

// @data de lombok lo que hace es crear implicitamente los getter and setters
@Data
// @Entity lo que significa es que esta clase va a tener acceso a una tabla porque es una entidad
@Entity
// Significa que esta clase va a mapear la tabla compras de la base de datos
@Table(name="compras")

// Se realiza un implements Serializable para que esta clase pueda guardar la información
public class Compras implements Serializable{
    
    // Esta variable se debe llamar serialVersionUID ya que así la utiliza la base de datos
    // para el manego de la llave primaria
    private static final long serialVersionUID = 1L;
    
    // @Id es para indicar que esa variable va a ser la clave primaria en la tabla
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) indica que la generación de la numeración
    // la va a realizar la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column (name="idCompras") significa que la variable va a ser referencia a la columna
    // idCompras de la base de datos
    @Column (name="id_compra")
    private Long idCompra;
    
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name="evento_id")
    Eventos eventos;
    
    @ManyToOne
    @JoinColumn(name="seccion_id")
    Secciones secciones;
    
    @ManyToOne
    @JoinColumn(name="usuario_id")
    Usuarios usuarios;
}
