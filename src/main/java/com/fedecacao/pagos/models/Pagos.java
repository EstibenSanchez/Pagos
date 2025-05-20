package com.fedecacao.pagos.models;


import com.fedecacao.pagos.enums.CodEstadoPago;
import com.fedecacao.pagos.enums.CodMedioPago;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

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
    @Enumerated(EnumType.STRING)
    private CodMedioPago codMedioPago;
    private BigDecimal valorPagado;
    private LocalDateTime fechaPago;

}
