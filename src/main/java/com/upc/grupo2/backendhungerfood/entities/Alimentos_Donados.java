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
public class Alimentos_Donados {
    //Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alimentos_donados_id")
private Long id; //id del alimento donado
    //Nombre_Alimento
    @Column(name = "Nombre_Alimento",length = 60, nullable = false)
private String nombre_alimento; //nombre del alimento donado
    //Descrtipcion_espeficico
    @Column(name = "Descripcion_especifico",length = 60, nullable = false)
private String descripcion_especifico; //descripcion especifica del alimento donado
    //Fecha_emision
    @Column(name = "Fecha_emision",length = 60, nullable = false)
    private LocalDate fecha_emision; //fecha de emision del alimento donado
    //Fecha_vencimiento
    @Column(name = "Fecha_vencimiento",length = 60, nullable = false)
    private LocalDate fecha_vencimiento; //fecha de vencimiento del alimento donado

    //ManytoOne
    //@JoinColumn(name = Tipo_alimento_id, nullable = false)
    //private Tipo_Alimento tipo_alimento_id;
}
