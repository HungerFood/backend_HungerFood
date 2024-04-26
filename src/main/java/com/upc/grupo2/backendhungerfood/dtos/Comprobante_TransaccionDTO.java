package com.upc.grupo2.backendhungerfood.dtos;

import com.upc.grupo2.backendhungerfood.entities.Metodo_De_Pago;
import com.upc.grupo2.backendhungerfood.entities.Usuario;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comprobante_TransaccionDTO {
    private Long id;
    private Double montoTotal;
    private Usuario usuario;
    private Metodo_De_Pago metodo_de_pago;
}
