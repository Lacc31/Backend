package com.crud.tfconectados.servicios;

import com.crud.tfconectados.dto.InsigniaDto;
import com.crud.tfconectados.entidades.Insignia;
import com.crud.tfconectados.interfaces.IInsigniaService;
import com.crud.tfconectados.repositorios.InsigniaRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsigniaService implements IInsigniaService {
    @Autowired
    private InsigniaRepositorio insigniaRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public InsigniaDto grabarInsignia(InsigniaDto insigniaDto) {
        Insignia insignia = modelMapper.map(insigniaDto, Insignia.class);
        Insignia guardar = insigniaRepositorio.save(insignia);
        return modelMapper.map(guardar, InsigniaDto.class);
    }

    @Override
    public List<InsigniaDto> listInsignias() {
        return insigniaRepositorio.findAll().stream().map(insignia -> modelMapper.map(insignia, InsigniaDto.class)).collect(Collectors.toList());
    }

    @Override
    public InsigniaDto editar(InsigniaDto insignia) {
        if (insigniaRepositorio.findById(insignia.getId()).isPresent()) {
            Insignia insigniaEntidad = modelMapper.map(insignia, Insignia.class);
            Insignia guardar = insigniaRepositorio.save(insigniaEntidad);
            return modelMapper.map(guardar, InsigniaDto.class);
        }
        return null;
    }
}
