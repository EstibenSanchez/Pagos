package com.fedecacao.pagos.services;

import com.fedecacao.pagos.dtos.PagosMapper;
import com.fedecacao.pagos.dtos.dtos.PagosDto;
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
    public PagosDto getPagosById(int id) {
        return null;
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
}
