package com.crud.tfconectados.servicios;

import com.crud.tfconectados.dto.ProgresoCursoUsuarioDto;
import com.crud.tfconectados.entidades.ProgresoCursoUsuario;
import com.crud.tfconectados.interfaces.IProgresoService;
import com.crud.tfconectados.repositorios.ProgresoCursoUsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgresoService implements IProgresoService {
    @Autowired
    private ProgresoCursoUsuarioRepositorio progresoCursoUsuarioRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ProgresoCursoUsuarioDto grabarProgresoCursoUsuario(ProgresoCursoUsuarioDto progresoCursoUsuarioDto) {
        ProgresoCursoUsuario progresoCursoUsuario = modelMapper.map(progresoCursoUsuarioDto, ProgresoCursoUsuario.class);
        ProgresoCursoUsuario guardar = progresoCursoUsuarioRepositorio.save(progresoCursoUsuario);
        return modelMapper.map(guardar, ProgresoCursoUsuarioDto.class);
    }

    @Override
    public List<ProgresoCursoUsuarioDto> listProgreso() {
        return progresoCursoUsuarioRepositorio.findAll().stream().map(progreso -> modelMapper.map(progreso, ProgresoCursoUsuarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public ProgresoCursoUsuarioDto editar(ProgresoCursoUsuarioDto progreso) {
        if (progresoCursoUsuarioRepositorio.findById(progreso.getId()).isPresent()) {
            ProgresoCursoUsuario progresoCursoUsuarioEntidad = modelMapper.map(progreso, ProgresoCursoUsuario.class);
            ProgresoCursoUsuario guardar = progresoCursoUsuarioRepositorio.save(progresoCursoUsuarioEntidad);
            return modelMapper.map(guardar, ProgresoCursoUsuarioDto.class);
        }
        return null;
    }
}
