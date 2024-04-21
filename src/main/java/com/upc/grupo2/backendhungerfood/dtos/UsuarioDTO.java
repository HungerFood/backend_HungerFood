package com.upc.grupo2.backendhungerfood.dtos;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String Nombre;
    private String Apellido;
    private String Correo;
    private String Contrasenia;

}
