package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.dtos.SumAlimentosDonadosDTO;
import com.upc.grupo2.backendhungerfood.entities.Alimentos_Donados_Por_Donante;
import com.upc.grupo2.backendhungerfood.repository.Alimentos_Donados_Por_DonanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Alimentos_Donados_Por_DonanteService {
    @Autowired
    private Alimentos_Donados_Por_DonanteRepository alimentos_Donados_Por_DonanteRepository;

    @Transactional
    //Registrar
    public Alimentos_Donados_Por_Donante registrar(Alimentos_Donados_Por_Donante alimentos_donados_por_donante){
        return alimentos_Donados_Por_DonanteRepository.save(alimentos_donados_por_donante);
    }
    //Listar
    public List<Alimentos_Donados_Por_Donante> listar(){
        return alimentos_Donados_Por_DonanteRepository.findAll();
    }
    //Actualizar
    public Alimentos_Donados_Por_Donante actualizar(Alimentos_Donados_Por_Donante alimentos_donados_por_donante){
        return alimentos_Donados_Por_DonanteRepository.save(alimentos_donados_por_donante);
    }
    //Eliminar
    public Alimentos_Donados_Por_Donante eliminar(Long id) throws Exception {
        Alimentos_Donados_Por_Donante alimentos_donados_por_donante = alimentos_Donados_Por_DonanteRepository.findById(id).orElseThrow(() -> new Exception("No se encontró"));
        alimentos_Donados_Por_DonanteRepository.delete(alimentos_donados_por_donante);
        return alimentos_donados_por_donante;
    }

    //Listar total de alimentos donados por donante buscado
    public SumAlimentosDonadosDTO getCantidadAlimentosDonadosPorDonante(Long usuarioId) {
        return alimentos_Donados_Por_DonanteRepository.findTotalAlimentosDonadosByUsuarioId(usuarioId);
    }

}
