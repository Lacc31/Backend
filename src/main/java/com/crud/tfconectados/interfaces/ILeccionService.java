package com.crud.tfconectados.interfaces;

import com.crud.tfconectados.dto.LeccionDto;

import java.util.List;


public interface ILeccionService {
    public LeccionDto grabarLeccion(LeccionDto leccionDto);

    public List<LeccionDto> listLecciones();

    public LeccionDto editar(LeccionDto leccionDto);
}
