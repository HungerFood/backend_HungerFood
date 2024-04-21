package com.upc.grupo2.backendhungerfood.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SumTransaccionDTO {
    private Double totalTransaccion;
    private String usuarioNombre;
}
