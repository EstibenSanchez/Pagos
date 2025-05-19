package com.fedecacao.pagos.dtos.dtos;

import com.fedecacao.pagos.enums.CodEstadoPago;
import com.fedecacao.pagos.enums.CodMedioPago;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PagosDto {
    private int idPago;
    private String codPagoRealizado;
    private CodEstadoPago codEstadoPago;
    private CodMedioPago codMedioPago;
    private BigDecimal valorPagado;
    private Date fechaPago;
}
