package com.Proyecto.service;

import com.Proyecto.domain.MetodoPago;
import java.util.List;

public interface MetodoPagoService {

    // Obtener un listado de todos los métodos de pago
    public List<MetodoPago> listarMetodosPago();

    // Obtener un método de pago específico por su ID
    public MetodoPago encontrarMetodoPago(MetodoPago metodoPago);

    // Guardar o actualizar un método de pago
    // Si el ID del método de pago está vacío, se insertará un nuevo registro
    // Si el ID del método de pago no está vacío, se actualizará el registro existente
    public void guardarMetodoPago(MetodoPago metodoPago);

    // Eliminar un método de pago específico
    public void eliminarMetodoPago(MetodoPago metodoPago);
}
