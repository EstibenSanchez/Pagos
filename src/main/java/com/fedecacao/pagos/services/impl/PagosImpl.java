package com.fedecacao.pagos.services.impl;

import com.fedecacao.pagos.dtos.dtos.PagosDto;

import java.util.List;

public interface PagosImpl {
    void savePagos(PagosDto pagosDto);

    List<PagosDto> getAllPagos();

    PagosDto getPagosById(int id);

    void deletePagosById(int id);

    void updatePagos(PagosDto pagosDto);

    List<PagosDto> getTopPagosByFranchise(int franchiseId);

    //void processWebhookEvent();
}
