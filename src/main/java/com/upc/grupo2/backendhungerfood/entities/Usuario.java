package com.upc.grupo2.backendhungerfood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "usuario_id")
    private Long id; //id del usuario

    //Nombre
    @Column(name = "Nombre",length = 60, nullable = false)
    private String nombre; //nombre del usuario

    //Apellido
    @Column(name = "Apellido",length = 60, nullable = false)
    private String apellido; //apellido del usuario

    //Correo y sea único
    @Column(name = "Correo", length = 60,nullable = false, unique = true)
    private String correo; //correo del usuario

    //Contraseña
    @Column(length = 60,nullable = false)
    private String contrasenia; //contraseña del usuario

    //id roles

    //id tipo donacion

}
