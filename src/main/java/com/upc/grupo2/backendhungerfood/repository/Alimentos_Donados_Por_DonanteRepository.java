package com.upc.grupo2.backendhungerfood.repository;

import com.upc.grupo2.backendhungerfood.dtos.SumAlimentosDonadosDTO;
import com.upc.grupo2.backendhungerfood.entities.Alimentos_Donados_Por_Donante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface Alimentos_Donados_Por_DonanteRepository extends JpaRepository<Alimentos_Donados_Por_Donante, Long>{
    @Query("SELECT new com.upc.grupo2.backendhungerfood.dtos.SumAlimentosDonadosDTO(SUM(ad.cantidadAlimentos), ad.usuario.nombre) FROM Alimentos_Donados_Por_Donante ad WHERE ad.usuario.id = :usuarioId GROUP BY ad.usuario.nombre")
    SumAlimentosDonadosDTO findTotalAlimentosDonadosByUsuarioId(@Param("usuarioId") Long usuarioId);
}
