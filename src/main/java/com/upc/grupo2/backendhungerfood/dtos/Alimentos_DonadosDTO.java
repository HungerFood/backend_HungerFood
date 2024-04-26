package com.upc.grupo2.backendhungerfood.dtos;

import com.upc.grupo2.backendhungerfood.entities.Tipo_Alimento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alimentos_DonadosDTO {
    private Long id;
    private String nombre_alimento;
    private String descripcion_especifico;
    private LocalDate fecha_emision;
    private LocalDate fecha_vencimiento;
    private Tipo_Alimento tipo_alimento;

}
