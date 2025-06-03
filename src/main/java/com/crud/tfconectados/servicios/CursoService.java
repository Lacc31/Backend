package com.crud.tfconectados.servicios;


import com.crud.tfconectados.dto.CursoDto;
import com.crud.tfconectados.entidades.Curso;
import com.crud.tfconectados.interfaces.ICursoService;
import com.crud.tfconectados.repositorios.CursoRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService implements ICursoService {
    @Autowired
    private CursoRepositorio cursoRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CursoDto grabarCurso(CursoDto cursoDto) {
        Curso curso = modelMapper.map(cursoDto, Curso.class);
        Curso guardar = cursoRepositorio.save(curso);
        return modelMapper.map(guardar, CursoDto.class);
    }

    @Override
    public List<CursoDto> listarCursos() {
        return cursoRepositorio.findAll().stream().map(curso -> modelMapper.map(curso, CursoDto.class)).collect(Collectors.toList());
    }

    @Override
    public CursoDto editar(CursoDto curso) {
        if (cursoRepositorio.findById(curso.getId()).isPresent()) {
            Curso cursoEntidad = modelMapper.map(curso, Curso.class);
            Curso guardar = cursoRepositorio.save(cursoEntidad);
            return modelMapper.map(guardar, CursoDto.class);
        }
        return null;
    }
}
