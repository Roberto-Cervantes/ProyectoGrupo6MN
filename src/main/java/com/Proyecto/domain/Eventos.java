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
// Significa que esta clase va a mapear la tabla eventos de la base de datos
@Table(name="eventos")

// Se realiza un implements Serializable para que esta clase pueda guardar la información
public class Eventos implements Serializable{
    
    // Esta variable se debe llamar serialVersionUID ya que así la utiliza la base de datos
    // para el manego de la llave primaria
    private static final long serialVersionUID = 1L;
    
    // @Id es para indicar que esa variable va a ser la clave primaria en la tabla
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY) indica que la generación de la numeración
    // la va a realizar la base de datos
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column (name="idEventos") significa que la variable va a ser referencia a la columna
    // idEventos de la base de datos
    @Column (name="id_Evento")
    private Long idEvento;
    private String descripcion;
    private Long artistaId;
    private String dia;
    private String hora;
    private String precio;
    private String rutaImagen;
}
