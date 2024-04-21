package com.upc.grupo2.backendhungerfood.repository;

import com.upc.grupo2.backendhungerfood.entities.Alimentos_Donados;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Alimentos_DonadosRepository extends JpaRepository<Alimentos_Donados, Long>{
}
