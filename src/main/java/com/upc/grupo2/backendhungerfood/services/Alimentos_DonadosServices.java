package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.entities.Alimentos_Donados;
import com.upc.grupo2.backendhungerfood.repository.Alimentos_DonadosRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Alimentos_DonadosServices {
    @Autowired
    private Alimentos_DonadosRepository alimentos_donadosRepository;
    //Registrar Alimentos Donados
    @Transactional
    public Alimentos_Donados registrarAlimentosDonados(Alimentos_Donados alimentos_donados){
        return alimentos_donadosRepository.save(alimentos_donados);
    }
    //Listar Alimentos Donados
    public List<Alimentos_Donados> listarAlimentosDonados(){
        return alimentos_donadosRepository.findAll();
    }
    //Actualizar Alimentos Donados
    public Alimentos_Donados actualizarAlimentosDonados(Alimentos_Donados alimentos_donados){
        return alimentos_donadosRepository.save(alimentos_donados);
    }
    //Eliminar Alimentos Donados
    public Alimentos_Donados eliminarAlimentosDonados(Long id) throws Exception {
        Alimentos_Donados alimentos_donados = alimentos_donadosRepository.findById(id).orElseThrow(() -> new Exception("No se encontró entidad"));
        alimentos_donadosRepository.delete(alimentos_donados);
        return alimentos_donados;
    }
}
