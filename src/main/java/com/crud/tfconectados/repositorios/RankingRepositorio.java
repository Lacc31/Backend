package com.crud.tfconectados.repositorios;

import com.crud.tfconectados.entidades.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RankingRepositorio extends JpaRepository<Ranking, Long> {
    public List<Ranking> findAllByOrderByPuntosDesc();
}
