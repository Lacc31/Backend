package com.crud.tfconectados.interfaces;

import com.crud.tfconectados.dto.UsuarioDto;
import com.crud.tfconectados.entidades.Usuario;

import java.util.List;

public interface IUsuarioService {
    public UsuarioDto grabarUsuario(UsuarioDto usuario);

    public Usuario obtenerUsuarioPorId(Long id);

    public List<UsuarioDto> listarUsuarios();

    public UsuarioDto editar(UsuarioDto usuario);
}
