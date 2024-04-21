package com.upc.grupo2.backendhungerfood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Detalle_Transaccion {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detalle_transaccion_id")
    private Long id;

    @Column(name = "Monto_transaccion", nullable = false)
    private Double Monto_transaccion;

    // @ManytoOne
   // @JointoColumn(name = "Comprobante_transaccion_id", nullable = false)
    // private Comprobante_transaccion Comprobante_transaccion_id;




}
