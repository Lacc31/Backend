package com.crud.tfconectados.repositorios;

import com.crud.tfconectados.entidades.LogroUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogroRepositorio extends JpaRepository<LogroUsuario, Long> {
}
