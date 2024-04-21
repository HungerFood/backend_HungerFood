package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.Tipo_AlimentoDTO;
import com.upc.grupo2.backendhungerfood.dtos.UsuarioDTO;
import com.upc.grupo2.backendhungerfood.entities.Tipo_Alimento;
import com.upc.grupo2.backendhungerfood.entities.Usuario;
import com.upc.grupo2.backendhungerfood.repository.Tipo_AlimentoRepository;
import com.upc.grupo2.backendhungerfood.services.Tipo_AlimentoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/HungerFood/Tipo_Alimento")
public class Tipo_AlimentoController {
    @Autowired
    private Tipo_AlimentoService tipo_alimentoService;
    //Registrar tipo alimento
    @PostMapping("/RegistrarTipoAlimento")
    public ResponseEntity<Tipo_AlimentoDTO> registrarTipoAlimento(@RequestBody Tipo_AlimentoDTO tipo_alimentoDTO){
        try{
            // Validar los datos del DTO
            if (tipo_alimentoDTO.getNombre_tipo_alimento() == null || tipo_alimentoDTO.getDescripcion_general() == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Datos de tipo alimento inválidos");
            }

            ModelMapper modelMapper = new ModelMapper();
            Tipo_Alimento tipo_alimento = modelMapper.map(tipo_alimentoDTO, Tipo_Alimento.class);
            tipo_alimento = tipo_alimentoService.registrarTipoAlimento(tipo_alimento);
            tipo_alimentoDTO = modelMapper.map(tipo_alimento, Tipo_AlimentoDTO.class);
            return new ResponseEntity<>(tipo_alimentoDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar tipo alimento");
        }
    }
    //Listar tipo alimento
    @GetMapping("/ListarTipoAlimento")
    public ResponseEntity<List<Tipo_AlimentoDTO>> findAll(){
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Tipo_AlimentoDTO> list = Arrays.asList(modelMapper.map(tipo_alimentoService.listarTipoAlimento(),
                    Tipo_AlimentoDTO[].class));
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar tipo alimento");
        }
    }
    //Actualizar tipo alimento
    @PutMapping("/ActualizarTipoAlimento")
    public ResponseEntity<Tipo_AlimentoDTO> actualizarTipoAlimento(@RequestBody Tipo_AlimentoDTO tipo_alimentoDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Tipo_Alimento tipo_alimento = modelMapper.map(tipo_alimentoDTO, Tipo_Alimento.class);
            tipo_alimento = tipo_alimentoService.actualizarTipoAlimento(tipo_alimento);
            tipo_alimentoDTO = modelMapper.map(tipo_alimento, Tipo_AlimentoDTO.class);
            return new ResponseEntity<>(tipo_alimentoDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar tipo alimento");
        }
    }
    //Eliminar tipo alimento
    @DeleteMapping("/EliminarTipoAlimento/{id}")
    public ResponseEntity<Tipo_AlimentoDTO> eliminarTipoAlimento(@PathVariable("id") Long id){
        Tipo_Alimento tipo_alimento;
        Tipo_AlimentoDTO tipo_alimentoDTO;
        try{
            tipo_alimento = tipo_alimentoService.eliminarTipoAlimento(id);
            ModelMapper modelMapper = new ModelMapper();
            tipo_alimentoDTO = modelMapper.map(tipo_alimento, Tipo_AlimentoDTO.class);
            return new ResponseEntity<>(tipo_alimentoDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar tipo alimento");
        }
    }
}
