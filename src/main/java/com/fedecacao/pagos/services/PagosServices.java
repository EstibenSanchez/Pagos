package com.fedecacao.pagos.services;

import com.fedecacao.pagos.dtos.PagosMapper;
import com.fedecacao.pagos.dtos.dtos.PagosDto;
import com.fedecacao.pagos.dtos.dtos.WebhookDto;
import com.fedecacao.pagos.enums.CodEstadoPago;
import com.fedecacao.pagos.enums.CodMedioPago;
import com.fedecacao.pagos.models.Pagos;
import com.fedecacao.pagos.repositories.PagosRepository;
import com.fedecacao.pagos.services.impl.PagosImpl;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagosServices implements PagosImpl {

    private final PagosRepository pagosRepository;
    private final PagosMapper pagosMapper;

    public PagosServices(PagosRepository pagosRepository, PagosMapper pagosMapper) {
        this.pagosRepository = pagosRepository;
        this.pagosMapper = pagosMapper;
    }

    @Override
    public void savePagos(PagosDto pagosDto) {
        Pagos pago = pagosMapper.toEntity(pagosDto);
        pagosRepository.save(pago);
    }

    @Override
    public List<PagosDto> getAllPagos() {
        return List.of();
    }

    @Override
    public PagosDto getPagosById(String id) {
        Pagos pagos = pagosRepository.findByCodPagoRealizado(id);
        return pagosMapper.toDto(pagos);
    }

    @Override
    public void deletePagosById(int id) {

    }

    @Override
    public void updatePagos(PagosDto pagosDto) {

    }


    @Override
    public void processWebhookEvent(WebhookDto payload) {
        Pagos pagos = pagosRepository.findByCodPagoRealizado(payload.getTransaction().getId());
        pagos.setFechaPago(payload.getEvent_date());
        pagos.setCodMedioPago(CodMedioPago.valueOf(payload.getTransaction().getMethod()));
        pagos.setValorPagado(payload.getTransaction().getAmount());
        switch(payload.getType()) {
            case "charge.created":
                pagos.setCodEstadoPago(CodEstadoPago.PENDIENTE);
                break;
            case "charge.cancelled":
                pagos.setCodEstadoPago(CodEstadoPago.CANCELADO);
                break;
            case "charge.failed":
                pagos.setCodEstadoPago(CodEstadoPago.FALLO);
                break;
            case  "charge.succeeded":
                pagos.setCodEstadoPago(CodEstadoPago.APROBADO);
                break;
            default:
                throw new IllegalArgumentException("Unknown event type: " + payload.getType());
        }
    }
}
