package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.Tipo_DonacionDTO;
import com.upc.grupo2.backendhungerfood.entities.Tipo_Donacion;
import com.upc.grupo2.backendhungerfood.services.Tipo_DonacionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/HungerFood/Tipo_Donacion")
public class Tipo_DonacionController {
    @Autowired
    private Tipo_DonacionService tipo_donacionService;

    //Registrar tipo alimento
    @PostMapping("/RegistrarTipoDonacion")
    public ResponseEntity<Tipo_DonacionDTO> registrarTipoDonacion(@RequestBody Tipo_DonacionDTO tipo_donacionDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Tipo_Donacion tipo_donacion = modelMapper.map(tipo_donacionDTO, Tipo_Donacion.class);
            tipo_donacion = tipo_donacionService.registrar_tipo_donacion(tipo_donacion);
            tipo_donacionDTO = modelMapper.map( tipo_donacion, Tipo_DonacionDTO.class);
            return new ResponseEntity<>(tipo_donacionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar tipo alimento");
        }
    }
    //Listar tipo alimento
    @GetMapping("/ListarTipoDonacion")
    public ResponseEntity<List<Tipo_DonacionDTO>> findAll(){
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Tipo_DonacionDTO> list = Arrays.asList(modelMapper.map(tipo_donacionService.listarTipoDonacion(),
                    Tipo_DonacionDTO[].class));
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar tipo alimento");
        }
    }
    //Actualizar tipo alimento
    @PutMapping("/ActualizarTipoDonacion")
    public ResponseEntity<Tipo_DonacionDTO> actualizarTipoDonacion(@RequestBody Tipo_DonacionDTO Tipo_DonacionDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Tipo_Donacion tipo_donacion = modelMapper.map(Tipo_DonacionDTO, Tipo_Donacion.class);
            tipo_donacion = tipo_donacionService.actualizarTipoDonacion(tipo_donacion);
            Tipo_DonacionDTO = modelMapper.map(tipo_donacion, Tipo_DonacionDTO.class);
            return new ResponseEntity<>( Tipo_DonacionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar tipo alimento");
        }
    }
    //Eliminar tipo alimento
    @DeleteMapping("/EliminarTipoDonacion/{id}")
    public ResponseEntity<Tipo_DonacionDTO> eliminarTipoDonacion(@PathVariable("id") Long id){
        Tipo_Donacion tipo_donacion;
        Tipo_DonacionDTO tipo_donacionDTO;
        try{
            tipo_donacion = tipo_donacionService.eliminarTipoDonacion(id);
            ModelMapper modelMapper = new ModelMapper();
            tipo_donacionDTO = modelMapper.map(tipo_donacion, Tipo_DonacionDTO.class);
            return new ResponseEntity<>(tipo_donacionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar tipo alimento");
        }
    }
}
