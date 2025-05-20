package com.fedecacao.pagos.repositories;

import com.fedecacao.pagos.dtos.dtos.PagosDto;
import com.fedecacao.pagos.models.Pagos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagosRepository extends JpaRepository<Pagos, Integer> {
    Pagos findByCodPagoRealizado(String id);
}
