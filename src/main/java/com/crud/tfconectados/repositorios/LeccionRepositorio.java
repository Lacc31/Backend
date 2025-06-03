package com.crud.tfconectados.repositorios;

import com.crud.tfconectados.entidades.Leccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeccionRepositorio extends JpaRepository<Leccion, Long> {
}
