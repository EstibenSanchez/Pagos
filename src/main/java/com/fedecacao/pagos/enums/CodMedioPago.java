package com.fedecacao.pagos.enums;

public enum CodMedioPago {
    bank_account("BC");

    private final String codigo;

    CodMedioPago(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public static CodMedioPago fromCodigo(String codigo) {
        for (CodMedioPago medio : values()) {
            if (medio.codigo.equals(codigo)) {
                return medio;
            }
        }
        throw new IllegalArgumentException("Código de medio de pago no válido: " + codigo);
    }
}
