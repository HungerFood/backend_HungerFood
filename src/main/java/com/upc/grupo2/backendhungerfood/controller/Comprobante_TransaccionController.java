package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.dtos.Comprobante_TransaccionDTO;
import com.upc.grupo2.backendhungerfood.dtos.SumTransaccionDTO;
import com.upc.grupo2.backendhungerfood.entities.Comprobante_Transaccion;
import com.upc.grupo2.backendhungerfood.services.Comprobante_TransaccionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/HungerFood/ComprobanteTransaccion")
public class Comprobante_TransaccionController {
    @Autowired
    private Comprobante_TransaccionService comprobante_transaccionService;
    @Autowired
    private Comprobante_TransaccionService comprobante_TransaccionService;

    //Registrar
    @PostMapping("/RegistrarComprobanteTransaccion")
    public ResponseEntity<Comprobante_TransaccionDTO> registrar(@RequestBody Comprobante_TransaccionDTO comprobante_transaccionDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Comprobante_Transaccion comprobante_transaccion = modelMapper.map(comprobante_transaccionDTO, Comprobante_Transaccion.class);
            comprobante_transaccion = comprobante_transaccionService.registrar(comprobante_transaccion);
            comprobante_transaccionDTO = modelMapper.map(comprobante_transaccion, Comprobante_TransaccionDTO.class);
            return new ResponseEntity<>(comprobante_transaccionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar");
        }
    }

    //Listar
    @GetMapping("/ListarComprobanteTransaccion")
    public ResponseEntity<List<Comprobante_TransaccionDTO>> findAll(){
        try {
            ModelMapper modelMapper = new ModelMapper();
            List<Comprobante_TransaccionDTO> list = Arrays.asList(modelMapper.map(comprobante_transaccionService.listar(),
                    Comprobante_TransaccionDTO[].class));
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar");
        }
    }

    //Actualizar
    @PutMapping("/ActualizarComprobanteTransaccion")
    public ResponseEntity<Comprobante_TransaccionDTO> actualizarUsuario(@RequestBody Comprobante_TransaccionDTO comprobante_transaccionDTO){
        try{
            ModelMapper modelMapper = new ModelMapper();
            Comprobante_Transaccion comprobante_transaccion = modelMapper.map(comprobante_transaccionDTO, Comprobante_Transaccion.class);
            comprobante_transaccion = comprobante_transaccionService.actualizar(comprobante_transaccion);
            comprobante_transaccionDTO = modelMapper.map(comprobante_transaccion, Comprobante_TransaccionDTO.class);
            return new ResponseEntity<>(comprobante_transaccionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar");
        }
    }

    //Eliminar
    @DeleteMapping("/EliminarComprobanteTransaccion/{id}")
    public ResponseEntity<Comprobante_TransaccionDTO> eliminar(@PathVariable("id") Long id){
        Comprobante_Transaccion comprobante_transaccion;
        Comprobante_TransaccionDTO comprobante_transaccionDTO;
        try{
            comprobante_transaccion = comprobante_transaccionService.eliminar(id);
            ModelMapper modelMapper = new ModelMapper();
            comprobante_transaccionDTO = modelMapper.map(comprobante_transaccion, Comprobante_TransaccionDTO.class);
            return new ResponseEntity<>(comprobante_transaccionDTO, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar");
        }
    }

    //Listar total de transacciones por donante buscado
    @GetMapping("/ListarTransaccionPorUsuario/{usuarioId}")
    public ResponseEntity<SumTransaccionDTO> getMontoTransaccionByUsuarioId(@PathVariable("usuarioId") Long usuarioId){
        try{
            SumTransaccionDTO totalTransaccion = comprobante_TransaccionService.getMontoTransaccionByUsuarioId(usuarioId);
            return new ResponseEntity<>(totalTransaccion, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar por usuario");
        }
    }
}
