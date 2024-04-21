package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.Detalle_TransaccionDTO;
import com.upc.grupo2.backendhungerfood.dtos.UsuarioDTO;
import com.upc.grupo2.backendhungerfood.entities.Detalle_Transaccion;
import com.upc.grupo2.backendhungerfood.entities.Usuario;
import com.upc.grupo2.backendhungerfood.services.Detalle_TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/HungerFood/Detalle_Transaccion")
public class Detalle_TransaccionController {
    @Autowired
    private Detalle_TransaccionService detalle_transaccionService;

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
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar usuario");
        }
    }
}
