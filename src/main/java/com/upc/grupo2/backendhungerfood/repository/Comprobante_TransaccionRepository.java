package com.upc.grupo2.backendhungerfood.repository;

import com.upc.grupo2.backendhungerfood.dtos.SumTransaccionDTO;
import com.upc.grupo2.backendhungerfood.entities.Comprobante_Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Comprobante_TransaccionRepository extends JpaRepository<Comprobante_Transaccion, Long> {
    @Query("SELECT new com.upc.grupo2.backendhungerfood.dtos.SumTransaccionDTO(SUM(c.montoTotal), c.usuario.Nombre) FROM Comprobante_Transaccion c WHERE c.usuario.id = :usuarioId GROUP BY c.usuario.Nombre")
    SumTransaccionDTO findMontoTransaccionByUsuarioId(Long usuarioId);
}
