package com.fedecacao.pagos.dtos.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WebhookDto {
    private String type;
    private LocalDateTime eventDate;
    private TransactionDto transaction;
}
