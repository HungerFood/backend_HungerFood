package com.upc.grupo2.backendhungerfood.dtos;

import com.upc.grupo2.backendhungerfood.entities.Usuario;
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
    //private Metodo_de_pago metodo_de_pago;
}
