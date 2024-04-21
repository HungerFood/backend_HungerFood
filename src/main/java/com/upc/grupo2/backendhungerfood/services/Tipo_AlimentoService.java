package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.entities.Tipo_Alimento;
import com.upc.grupo2.backendhungerfood.entities.Usuario;
import com.upc.grupo2.backendhungerfood.repository.Tipo_AlimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Tipo_AlimentoService {

    @Autowired
    private Tipo_AlimentoRepository tipo_alimentoRepository;

    //Registrar tipo alimento
    @Transactional
    public Tipo_Alimento registrarTipoAlimento(Tipo_Alimento tipo_alimento){
        return tipo_alimentoRepository.save(tipo_alimento);
    }
    //Listar tipo alimento
    public List<Tipo_Alimento> listarTipoAlimento(){
        return tipo_alimentoRepository.findAll();
    }
    //Actualizar tipo alimento
    public Tipo_Alimento actualizarTipoAlimento(Tipo_Alimento tipo_alimento){
        return tipo_alimentoRepository.save(tipo_alimento);
    }
    //Eliminar tipo alimento
    public Tipo_Alimento eliminarTipoAlimento(Long id) throws Exception {
        Tipo_Alimento tipo_alimento = tipo_alimentoRepository.findById(id).orElseThrow(() -> new Exception("No se encontró entidad"));
        tipo_alimentoRepository.delete(tipo_alimento);
        return tipo_alimento;
    }
}
