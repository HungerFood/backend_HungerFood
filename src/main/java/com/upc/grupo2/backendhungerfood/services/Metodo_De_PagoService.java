package com.upc.grupo2.backendhungerfood.services;

import com.upc.grupo2.backendhungerfood.repository.Metodo_De_PagoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Metodo_De_PagoService {
    @Autowired
    private Metodo_De_PagoRepository metodo_de_pagoRepository;
    @Transactional


}
