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
    private Long id;

    //Nombre
    @Column(name = "Nombre",length = 60, nullable = false)
    private String Nombre;

    //Apellido
    @Column(name = "Apellido",length = 60, nullable = false)
    private String Apellido;

    //Correo y sea único
    @Column(name = "Correo", length = 60,nullable = false, unique = true)
    private String Correo;

    //Contraseña
    @Column(length = 60,nullable = false)
    private String Contrasenia;

    //id roles

    //id tipo donacion

    //hola soy diego
}
