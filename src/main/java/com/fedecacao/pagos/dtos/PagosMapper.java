package com.fedecacao.pagos.dtos;

import com.fedecacao.pagos.dtos.dtos.PagosDto;
import com.fedecacao.pagos.models.Pagos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PagosMapper {
    PagosDto toDto(Pagos pagos);

    Pagos toEntity(PagosDto pagosDto);
}
