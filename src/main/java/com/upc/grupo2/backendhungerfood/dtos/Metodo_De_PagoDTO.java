package com.upc.grupo2.backendhungerfood.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metodo_De_PagoDTO {
    private Long id;
    private String tipo;
}
