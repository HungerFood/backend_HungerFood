package com.upc.grupo2.backendhungerfood.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Comprobante_Transaccion {
    //ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comprobanteTransaccion_id")
    private Long id;

    //Monto total de transaccion en comprobante
    @Column(name = "Monto_total", nullable = false)
    private Double montoTotal;

    //Usuario(donante)
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    //Metodo_De_Pago
    @ManyToOne
    @JoinColumn(name = "Metodo_de_pago_id")
    private Metodo_De_Pago metodo_de_pago;
}
