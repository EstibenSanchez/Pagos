package com.fedecacao.pagos.enums;

public enum CodEstadoPago {
    PENDIENTE("P"),
    APROBADO("A"),
    RECHAZADO("R");

    private final String codigo;

    CodEstadoPago(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static CodEstadoPago fromCodigo(String codigo) {
        for (CodEstadoPago estado : values()) {
            if (estado.codigo.equals(codigo)) {
                return estado;
            }
        }
        throw new IllegalArgumentException("Código de estado de pago no válido: " + codigo);
    }
}
