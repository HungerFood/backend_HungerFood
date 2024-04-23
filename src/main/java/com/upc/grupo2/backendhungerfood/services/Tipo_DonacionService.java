package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.entities.Tipo_Donacion;
import com.upc.grupo2.backendhungerfood.repository.Tipo_DonacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Tipo_DonacionService {
    @Autowired
    private Tipo_DonacionRepository tipo_donacionRepository;

    //Registrar tipo donacion
    @Transactional
    public Tipo_Donacion registrar_tipo_donacion(Tipo_Donacion tipo_donacion){
        return tipo_donacionRepository.save(tipo_donacion);
    }
    //Listar tipo alimento
    public List<Tipo_Donacion> listarTipoDonacion(){
        return tipo_donacionRepository.findAll();
    }
    //Actualizar tipo alimento
    public Tipo_Donacion actualizarTipoDonacion(Tipo_Donacion tipo_donacion){
        return tipo_donacionRepository.save(tipo_donacion);
    }
    //Eliminar tipo alimento
    public Tipo_Donacion eliminarTipoDonacion(Long id) throws Exception {
        Tipo_Donacion tipo_donacion = tipo_donacionRepository.findById(id).orElseThrow(() -> new Exception("No se encontró entidad"));
        tipo_donacionRepository.delete(tipo_donacion);
        return tipo_donacion;
    }
}
