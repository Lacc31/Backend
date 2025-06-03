package com.crud.tfconectados.interfaces;

import com.crud.tfconectados.dto.InsigniaDto;

import java.util.List;

public interface IInsigniaService {
    public InsigniaDto grabarInsignia(InsigniaDto insigniaDto);

    public List<InsigniaDto> listInsignias();

    public InsigniaDto editar(InsigniaDto insigniaDto);
}
