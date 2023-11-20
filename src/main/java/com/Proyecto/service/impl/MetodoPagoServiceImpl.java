package com.Proyecto.service.impl;

import com.Proyecto.dao.MetodoPagoDao;
import com.Proyecto.domain.MetodoPago;
import com.Proyecto.service.MetodoPagoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MetodoPagoServiceImpl implements MetodoPagoService {

    @Autowired
    private MetodoPagoDao metodoPagoDao;

    @Override
    @Transactional(readOnly = true)
    public List<MetodoPago> listarMetodosPago() {
        return metodoPagoDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MetodoPago encontrarMetodoPago(MetodoPago metodoPago) {
        return metodoPagoDao.findById(metodoPago.getIdMetodoPago()).orElse(null);
    }

    @Override
    @Transactional
    public void guardarMetodoPago(MetodoPago metodoPago) {
        metodoPagoDao.save(metodoPago);
    }

    @Override
    @Transactional
    public void eliminarMetodoPago(MetodoPago metodoPago) {
        metodoPagoDao.delete(metodoPago);
    }
}
