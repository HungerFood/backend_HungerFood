package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.entities.Metodo_De_Pago;
import com.upc.grupo2.backendhungerfood.repository.Metodo_De_PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Metodo_De_PagoService {
    @Autowired
    private Metodo_De_PagoRepository metodo_de_pagoRepository;
    //Registrar MetodoDePago
    @Transactional
    public Metodo_De_Pago registrarMetodoDePago(Metodo_De_Pago metodo_de_pago){return metodo_de_pagoRepository.save(metodo_de_pago);}
    //Lista MetodoDePago
    public List<Metodo_De_Pago> listarMetodoDePago(){return metodo_de_pagoRepository.findAll();}
    //Actualizar MetodoDePago
    public Metodo_De_Pago actualizarMetodoDePago(Metodo_De_Pago metodo_de_pago){return metodo_de_pagoRepository.save(metodo_de_pago);}
    //Eliminar MetodoDePago
    public Metodo_De_Pago eliminarMetodoDePago(Long id) throws Exception {
        Metodo_De_Pago metodo_de_pago = metodo_de_pagoRepository.findById(id).orElseThrow(() -> new Exception("No se encontró entidad"));
        metodo_de_pagoRepository.delete(metodo_de_pago);
        return metodo_de_pago;
    }


}
