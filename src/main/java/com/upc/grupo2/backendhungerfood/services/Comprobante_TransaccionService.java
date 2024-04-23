package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.dtos.SumTransaccionDTO;
import com.upc.grupo2.backendhungerfood.entities.Comprobante_Transaccion;
import com.upc.grupo2.backendhungerfood.repository.Comprobante_TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Comprobante_TransaccionService {
    @Autowired
    private Comprobante_TransaccionRepository comprobante_TransaccionRepository;

    @Transactional
    //Registrar
    public Comprobante_Transaccion registrar(Comprobante_Transaccion comprobante_Transaccion){
        return comprobante_TransaccionRepository.save(comprobante_Transaccion);
    }
    //Listar
    public List<Comprobante_Transaccion> listar(){
        return comprobante_TransaccionRepository.findAll();
    }
    //Actualizar
    public Comprobante_Transaccion actualizar(Comprobante_Transaccion comprobante_Transaccion){
        return comprobante_TransaccionRepository.save(comprobante_Transaccion);
    }
    //Eliminar
    public Comprobante_Transaccion eliminar(Long id) throws Exception {
        Comprobante_Transaccion comprobante_Transaccion = comprobante_TransaccionRepository.findById(id).orElseThrow(() -> new Exception("No se encontró"));
        comprobante_TransaccionRepository.delete(comprobante_Transaccion);
        return comprobante_Transaccion;
    }
    //Listar total de transacciones por donante buscado
    public SumTransaccionDTO getMontoTransaccionByUsuarioId(Long usuarioId) {
        return comprobante_TransaccionRepository.findMontoTransaccionByUsuarioId(usuarioId);
    }
}
