package com.upc.grupo2.backendhungerfood.dtos;

import com.upc.grupo2.backendhungerfood.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private List<Role> roles;
}
