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
        return pagosRepository.findByCodPagoRealizado(id);
    }

    @Override
    public void deletePagosById(int id) {

    }

    @Override
    public void updatePagos(PagosDto pagosDto) {

    }

    @Override
    public List<PagosDto> getTopPagosByFranchise(int franchiseId) {
        return List.of();
    }

    @Override
    public void processWebhookEvent(WebhookDto payload) {
        PagosDto pagosDto = pagosRepository.findByCodPagoRealizado(payload.getTransaction().getId());
        pagosDto.setFechaPago(payload.getEvent_date());
        pagosDto.setCodMedioPago(CodMedioPago.valueOf(payload.getTransaction().getMethod()));
        pagosDto.setValorPagado(payload.getTransaction().getAmount());
        switch(payload.getType()) {
            case "charge.created":
                pagosDto.setCodEstadoPago(CodEstadoPago.PENDIENTE);
                break;
            case "charge.cancelled":
                pagosDto.setCodEstadoPago(CodEstadoPago.CANCELADO);
                break;
            case "charge.failed":
                pagosDto.setCodEstadoPago(CodEstadoPago.FALLO);
                break;
            case  "charge.succeeded":
                pagosDto.setCodEstadoPago(CodEstadoPago.APROBADO);
                break;
            default:
                throw new IllegalArgumentException("Unknown event type: " + payload.getType());
        }
    }
}
