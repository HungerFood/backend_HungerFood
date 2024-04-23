package com.upc.grupo2.backendhungerfood.dtos;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipo_DonacionDTO {
    private Long id;
    private String nombre_tipo_donacion;
}
