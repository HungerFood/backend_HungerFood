package com.upc.grupo2.backendhungerfood.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tipo_AlimentoDTO {
    private Long id;
    private String nombre_tipo_alimento;
    private String descripcion_general;
}
