package com.fedecacao.pagos.dtos.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TransactionDto {
    private String id;
    private String status;
    private String createdAt;
    private  String description;
    private String orderId;
}
