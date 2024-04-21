package com.upc.grupo2.backendhungerfood.repository;

import com.upc.grupo2.backendhungerfood.entities.Detalle_Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Detalle_TransaccionRepository extends JpaRepository<Detalle_Transaccion, Long> {
}
