package com.crud.tfconectados.servicios;

import com.crud.tfconectados.dto.LeccionDto;
import com.crud.tfconectados.entidades.Leccion;
import com.crud.tfconectados.interfaces.ILeccionService;
import com.crud.tfconectados.repositorios.LeccionRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class LeccionService implements ILeccionService {
    @Autowired
    private LeccionRepositorio leccionRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LeccionDto grabarLeccion(LeccionDto leccionDto) {
        Leccion leccion = modelMapper.map(leccionDto, Leccion.class);
        Leccion guardar = leccionRepositorio.save(leccion);
        return modelMapper.map(guardar, LeccionDto.class);
    }

    @Override
    public List<LeccionDto> listLecciones() {
        return leccionRepositorio.findAll().stream().map(leccion -> modelMapper.map(leccion, LeccionDto.class)).collect(Collectors.toList());
    }

    @Override
    public LeccionDto editar(LeccionDto leccion) {
        if (leccionRepositorio.findById(leccion.getId()).isPresent()) {
            Leccion leccionEntidad = modelMapper.map(leccion, Leccion.class);
            Leccion guardar = leccionRepositorio.save(leccionEntidad);
            return modelMapper.map(guardar, LeccionDto.class);
        }
        return null;
    }
}
