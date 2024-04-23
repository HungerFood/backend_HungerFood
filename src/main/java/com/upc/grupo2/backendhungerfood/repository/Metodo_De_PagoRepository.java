package com.upc.grupo2.backendhungerfood.repository;

import com.upc.grupo2.backendhungerfood.entities.Metodo_De_Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Metodo_De_PagoRepository extends JpaRepository<Metodo_De_Pago, Long> {
}
