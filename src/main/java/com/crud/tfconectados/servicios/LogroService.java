package com.crud.tfconectados.servicios;

import com.crud.tfconectados.dto.LogroDto;
import com.crud.tfconectados.entidades.LogroUsuario;
import com.crud.tfconectados.interfaces.ILogroService;
import com.crud.tfconectados.repositorios.LogroRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogroService implements ILogroService {
    @Autowired
    private LogroRepositorio logroRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LogroDto grabarLogro(LogroDto logroDto) {
        LogroUsuario logroUsuario = modelMapper.map(logroDto, LogroUsuario.class);
        LogroUsuario guardar = logroRepositorio.save(logroUsuario);
        return modelMapper.map(guardar, LogroDto.class);
    }

    @Override
    public List<LogroDto> listLogro() {

        return logroRepositorio.findAll().stream().map(logro -> modelMapper.map(logro, LogroDto.class)).collect(Collectors.toList());
    }

    @Override
    public LogroDto editar(LogroDto logro) {
        if (logroRepositorio.findById(logro.getId()).isPresent()) {
            LogroUsuario logroEntidad = modelMapper.map(logro, LogroUsuario.class);
            LogroUsuario guardar = logroRepositorio.save(logroEntidad);
            return modelMapper.map(guardar, LogroDto.class);
        }
        return null;
    }
}
