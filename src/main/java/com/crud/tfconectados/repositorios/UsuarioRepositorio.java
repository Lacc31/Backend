package com.crud.tfconectados.repositorios;

import com.crud.tfconectados.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
