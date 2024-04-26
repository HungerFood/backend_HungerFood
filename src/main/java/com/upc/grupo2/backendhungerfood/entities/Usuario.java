package com.upc.grupo2.backendhungerfood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

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

    private Boolean enabled;

    //id roles
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    //id tipo donacion

}
