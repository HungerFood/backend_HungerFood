package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.repository.Detalle_TransaccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Detalle_TransaccionService {
    @Autowired
    private Detalle_TransaccionRepository detalle_transaccionRepository;
    @Transactional
    public void registrarDetalleTransaccion(){

    }
}
