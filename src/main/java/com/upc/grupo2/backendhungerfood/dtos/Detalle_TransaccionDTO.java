package com.upc.grupo2.backendhungerfood.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detalle_TransaccionDTO {
    private Long id;
    private Double Monto_transaccion;
    // private Comprobante_transaccion Comprobante_transaccion_id;
}
