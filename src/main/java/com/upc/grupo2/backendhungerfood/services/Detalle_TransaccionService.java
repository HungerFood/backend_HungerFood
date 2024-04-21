package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.entities.Detalle_Transaccion;
import com.upc.grupo2.backendhungerfood.repository.Detalle_TransaccionRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Detalle_TransaccionService {
    @Autowired
    private Detalle_TransaccionRepository detalle_transaccionRepository;
    //Registrar DetalleTransaccion
    @Transactional
    public Detalle_Transaccion registrarDetalleTransaccion(Detalle_Transaccion detalle_transaccion){ return detalle_transaccionRepository.save(detalle_transaccion);}

    //Lista DetalleTransaccion
    public List<Detalle_Transaccion> listarDetalleTransaccion(){return detalle_transaccionRepository.findAll();}

    //Actualizar DetalleTransaccion
    public Detalle_Transaccion actualizarDetalleTransaccion(Detalle_Transaccion detalle_transaccion){return detalle_transaccionRepository.save(detalle_transaccion);}

    //Eliminar DetalleTransaccion
    public Detalle_Transaccion eliminarDetalleTransaccion(Long id) throws Exception {
        Detalle_Transaccion detalle_transaccion = detalle_transaccionRepository.findById(id).orElseThrow(() -> new Exception("No se encontró entidad"));
        detalle_transaccionRepository.delete(detalle_transaccion);
        return detalle_transaccion;
    }
}
