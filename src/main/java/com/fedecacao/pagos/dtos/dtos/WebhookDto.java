package com.fedecacao.pagos.dtos.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class WebhookDto {
    private String type;
    private Date eventDate;
    private TransactionDto transaction;
    private String method;
}
