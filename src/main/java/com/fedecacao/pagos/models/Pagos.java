package com.fedecacao.pagos.models;


import com.fedecacao.pagos.enums.CodEstadoPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Pagos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPago;
    @NonNull
    private String codPagoRealizado;
    @NonNull
    @Enumerated(EnumType.STRING)
    private CodEstadoPago codEstadoPago;
    private BigDecimal valorPagado;
    private Date fechaPago;

}
