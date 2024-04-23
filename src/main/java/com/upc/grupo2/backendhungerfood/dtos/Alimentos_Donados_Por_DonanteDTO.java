package com.upc.grupo2.backendhungerfood.dtos;

import com.upc.grupo2.backendhungerfood.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alimentos_Donados_Por_DonanteDTO {
    private Long id;
    private LocalDate fechaDonacion;
    private Long cantidadAlimentos;
    private Usuario usuario;
    //private Alimentos_Donados alimentos_Donados;
}
