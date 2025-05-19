package com.fedecacao.pagos.dtos.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TransactionDto {
    private String id;
    private String status;
    private LocalDateTime creation_date;
    private String description;
    private String method;
}
