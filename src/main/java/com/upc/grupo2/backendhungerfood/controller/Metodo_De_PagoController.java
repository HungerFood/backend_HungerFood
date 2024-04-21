package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.entities.Metodo_De_Pago;
import com.upc.grupo2.backendhungerfood.services.Metodo_De_PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/HungerFood/Metodo_De_Pago")
public class Metodo_De_PagoController {
    @Autowired
    private Metodo_De_PagoService metodo_de_pagoService;
//Registrar MetodoDePago
    @PostMapping("/RegistrarMetodoDePago")
    public ResponseEntity<Metodo_De_Pago> registrarMetodoDePago(@RequestBody Metodo_De_Pago metodo_de_pago){
        try{
            metodo_de_pago = metodo_de_pagoService.registrarMetodoDePago(metodo_de_pago);
            return new ResponseEntity<>(metodo_de_pago, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al registrar metodo de pago");
        }

    }

    //Listar MetodoDePago
    @GetMapping("/ListarMetodoDePago")
    public ResponseEntity<List<Metodo_De_Pago>> findAll(){
        try {
            List<Metodo_De_Pago> list = metodo_de_pagoService.listarMetodoDePago();
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al listar metodo de pago");
        }
    }
    //Actualizar MetodoDePago
    @PutMapping("/ActualizarMetodoDePago")
    public ResponseEntity<Metodo_De_Pago> actualizarMetodoDePago(@RequestBody Metodo_De_Pago metodo_de_pago){
        try {
            metodo_de_pago = metodo_de_pagoService.actualizarMetodoDePago(metodo_de_pago);
            return new ResponseEntity<>(metodo_de_pago, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al actualizar metodo de pago");
        }
    }
    //Eliminar MetodoDePago
    @DeleteMapping("/EliminarMetodoDePago/{id}")
    public ResponseEntity<Metodo_De_Pago> eliminarMetodoDePago(@PathVariable Long id){
        try {
            Metodo_De_Pago metodo_de_pago = metodo_de_pagoService.eliminarMetodoDePago(id);
            return new ResponseEntity<>(metodo_de_pago, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error al eliminar metodo de pago");
        }
    }
}
