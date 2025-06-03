package com.crud.tfconectados.servicios;


import com.crud.tfconectados.dto.UsuarioDto;
import com.crud.tfconectados.entidades.Usuario;
import com.crud.tfconectados.interfaces.IUsuarioService;
import com.crud.tfconectados.repositorios.UsuarioRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;




@Service
public class UsuarioService implements IUsuarioService {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UsuarioDto grabarUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = modelMapper.map(usuarioDto, Usuario.class);
        Usuario guardar = usuarioRepositorio.save(usuario);
        return modelMapper.map(guardar, UsuarioDto.class);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        if (usuarioRepositorio.findById(id).isPresent()) {
            return usuarioRepositorio.findById(id).get();
        }
        return null;
    }

    @Override
    public List<UsuarioDto> listarUsuarios() {

        return usuarioRepositorio.findAll().stream().map(usuario -> modelMapper.map(usuario, UsuarioDto.class)).collect(Collectors.toList());
    }

    @Override
    public UsuarioDto editar(UsuarioDto usuario) {
        if (usuarioRepositorio.findById(usuario.getId()).isPresent()) {
            Usuario usuarioEntidad = modelMapper.map(usuario, Usuario.class);
            Usuario guardar = usuarioRepositorio.save(usuarioEntidad);
            return modelMapper.map(guardar, UsuarioDto.class);

        }
        return null;
    }

  //  @Override
   // public void eliminar(Long id) {
     //   if (usuarioRepositorio.findById(id).isPresent()) {
         //   usuarioRepositorio.deleteById(id);
       // }

    //}


}
