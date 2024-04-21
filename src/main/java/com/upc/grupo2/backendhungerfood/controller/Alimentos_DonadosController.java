package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.Alimentos_DonadosDTO;
import com.upc.grupo2.backendhungerfood.entities.Alimentos_Donados;
import com.upc.grupo2.backendhungerfood.services.Alimentos_DonadosServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/HungerFood/Alimentos_Donados")
//Registrar Alimentos Donados
public class Alimentos_DonadosController {
    @Autowired
    private Alimentos_DonadosServices alimentos_donadosServices;

    //Registrar Alimentos Donados
    @PostMapping("/RegistrarAlimentosDonados")
    public ResponseEntity<Alimentos_DonadosDTO> registrarAlimentosDonados(@RequestBody Alimentos_DonadosDTO alimentos_donadosDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Alimentos_Donados alimentos_donados = modelMapper.map(alimentos_donadosDTO, Alimentos_Donados.class);
            alimentos_donados = alimentos_donadosServices.registrarAlimentosDonados(alimentos_donados);
            alimentos_donadosDTO = modelMapper.map(alimentos_donados, Alimentos_DonadosDTO.class);
            return new ResponseEntity<>(alimentos_donadosDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar alimentos donados");
        }
    }

    //Listar Alimentos Donados
    @GetMapping("/ListarAlimentosDonados")
    public ResponseEntity<List<Alimentos_DonadosDTO>> findAll() {
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Alimentos_DonadosDTO> list = Arrays.asList(modelMapper.map(alimentos_donadosServices.listarAlimentosDonados(),
                    Alimentos_DonadosDTO[].class));
            return new ResponseEntity<>(list, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar alimentos donados");
        }
    }
    //Actualizar Alimentos Donados
    @PutMapping("/ActualizarAlimentosDonados")
    public ResponseEntity<Alimentos_DonadosDTO> actualizarAlimentosDonados(@RequestBody Alimentos_DonadosDTO alimentos_donadosDTO) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Alimentos_Donados alimentos_donados = modelMapper.map(alimentos_donadosDTO, Alimentos_Donados.class);
            alimentos_donados = alimentos_donadosServices.actualizarAlimentosDonados(alimentos_donados);
            alimentos_donadosDTO = modelMapper.map(alimentos_donados, Alimentos_DonadosDTO.class);
            return new ResponseEntity<>(alimentos_donadosDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar alimentos donados");
        }
    }
    //Eliminar Alimentos Donados
    @DeleteMapping("/EliminarAlimentosDonados/{id}")
    public ResponseEntity<Alimentos_DonadosDTO> eliminarAlimentosDonados(@PathVariable Long id) {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Alimentos_Donados alimentos_donados = alimentos_donadosServices.eliminarAlimentosDonados(id);
            Alimentos_DonadosDTO alimentos_donadosDTO = modelMapper.map(alimentos_donados, Alimentos_DonadosDTO.class);
            return new ResponseEntity<>(alimentos_donadosDTO, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar alimentos donados");
        }
    }
}
