package com.upc.grupo2.backendhungerfood.controller;

import com.upc.grupo2.backendhungerfood.services.Metodo_De_PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/HungerFood/Metodo_De_Pago")
public class Metodo_De_PagoController {
    @Autowired
    private Metodo_De_PagoService metodo_de_pagoService;

    @PostMapping("/RegistrarMetodoDePago")
    public ResponseEntity< > registrarMetodoDePago(){
        return ResponseEntity.ok().build();
    }
}
