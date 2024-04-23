package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.Detalle_TransaccionDTO;
import com.upc.grupo2.backendhungerfood.entities.Detalle_Transaccion;
import com.upc.grupo2.backendhungerfood.services.Detalle_TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/HungerFood/Detalle_Transaccion")
public class Detalle_TransaccionController {
    @Autowired
    private Detalle_TransaccionService detalle_transaccionService;

// registrar DetalleTransaccion
    @PostMapping("/RegistrarDetalleTransaccion")
    public ResponseEntity<Detalle_TransaccionDTO> registrarDetalleTransaccion(@RequestBody Detalle_TransaccionDTO detalle_transaccionDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Detalle_Transaccion detalle_transaccion = modelMapper.map(detalle_transaccionDTO, Detalle_Transaccion.class);
            detalle_transaccion = detalle_transaccionService.registrarDetalleTransaccion(detalle_transaccion);
            detalle_transaccionDTO = modelMapper.map(detalle_transaccion, Detalle_TransaccionDTO.class);
            return new ResponseEntity<>(detalle_transaccionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar detalle");
        }
    }

    //Listar DetalleTransaccion
    @GetMapping("/ListarDetalleTransaccion")
    public ResponseEntity<List<Detalle_TransaccionDTO>> findAll(){
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Detalle_TransaccionDTO> list = Arrays.asList(modelMapper.map(detalle_transaccionService.listarDetalleTransaccion(),
                    Detalle_TransaccionDTO[].class));
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar detalle");
        }
    }
    //Actualizar DetalleTransaccion
    @PutMapping("/ActualizarDetalleTransaccion")
    public ResponseEntity<Detalle_TransaccionDTO> actualizarDetalleTransaccion(@RequestBody Detalle_TransaccionDTO detalle_transaccionDTO){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Detalle_Transaccion detalle_transaccion = modelMapper.map(detalle_transaccionDTO, Detalle_Transaccion.class);
            detalle_transaccion = detalle_transaccionService.actualizarDetalleTransaccion(detalle_transaccion);
            detalle_transaccionDTO = modelMapper.map(detalle_transaccion, Detalle_TransaccionDTO.class);
            return new ResponseEntity<>(detalle_transaccionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();}
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar detalle");
        }
    //Eliminar DetalleTransaccion
    @DeleteMapping("/EliminarDetalleTransaccion/{id}")
    public ResponseEntity<Detalle_TransaccionDTO> eliminarDetalleTransaccion(@PathVariable Long id){
        try {
            ModelMapper modelMapper = new ModelMapper();
            Detalle_Transaccion detalle_transaccion = detalle_transaccionService.eliminarDetalleTransaccion(id);
            Detalle_TransaccionDTO detalle_transaccionDTO = modelMapper.map(detalle_transaccion, Detalle_TransaccionDTO.class);
            return new ResponseEntity<>(detalle_transaccionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar detalle");
        }
    }
}
