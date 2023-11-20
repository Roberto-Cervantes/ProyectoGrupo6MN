package com.Proyecto.dao;

import com.Proyecto.domain.MetodoPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetodoPagoDao extends JpaRepository<MetodoPago, Long> {

    // Aquí puedes agregar métodos personalizados si es necesario
}
