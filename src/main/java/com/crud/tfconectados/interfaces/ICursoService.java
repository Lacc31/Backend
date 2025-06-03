package com.crud.tfconectados.interfaces;

import com.crud.tfconectados.dto.CursoDto;

import java.util.List;

public interface ICursoService {
    public CursoDto grabarCurso(CursoDto cursoDto);

    public List<CursoDto> listarCursos();

    public CursoDto editar(CursoDto cursoDto);
}
