package com.crud.tfconectados.interfaces;

import com.crud.tfconectados.dto.ProgresoCursoUsuarioDto;

import java.util.List;

public interface IProgresoService {
    public ProgresoCursoUsuarioDto grabarProgresoCursoUsuario(ProgresoCursoUsuarioDto progresoCursoUsuarioDto);

    public List<ProgresoCursoUsuarioDto> listProgreso();

    public ProgresoCursoUsuarioDto editar(ProgresoCursoUsuarioDto progresoCursoUsuarioDto);
}
