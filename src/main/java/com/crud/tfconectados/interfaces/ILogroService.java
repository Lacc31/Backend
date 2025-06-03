package com.crud.tfconectados.interfaces;

import com.crud.tfconectados.dto.LogroDto;

import java.util.List;

public interface ILogroService {
    public LogroDto grabarLogro(LogroDto logroDto);

    public List<LogroDto> listLogro();

    public LogroDto editar(LogroDto logroDto);
}
