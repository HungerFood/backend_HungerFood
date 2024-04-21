package com.upc.grupo2.backendhungerfood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Tipo_Alimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //no quiero que aumente al momento de registrar incorrectamente, o sea no quiero que el nombre_alimento se repita, si es diferente, que se registre

    private Long id;
    @Column(name = "nombre_alimento",length = 100, nullable = false, unique = true)
    private String nombre_tipo_alimento;
    @Column(name = "descripcion_general",length = 100, nullable = false)
    private String descripcion_general;

}
