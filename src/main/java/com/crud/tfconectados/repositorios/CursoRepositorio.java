package com.crud.tfconectados.repositorios;

import com.crud.tfconectados.entidades.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepositorio extends JpaRepository<Curso, Long> {
}
