package com.upc.grupo2.backendhungerfood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Alimentos_Donados_Por_Donante {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alimentosDonadosPorDonante_id")
    private Long id;

    //Fecha de donacion
    @Column(name = "Fecha_donacion", nullable = false, unique = true)
    private LocalDate fechaDonacion;

    //Cantidad de alimentos donados
    @Column(name = "Cantidad_alimentos", nullable = false)
    private Long cantidadAlimentos;

    //Usuario(donante)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Alimentos_Donados
    //@ManyToOne
    //@JoinColumn(name = "Alimentos_Donados_id")
    //private Alimentos_Donados alimentos_Donados;

}
