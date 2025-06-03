package com.crud.tfconectados.interfaces;

import com.crud.tfconectados.dto.RankingDto;

import java.util.List;

public interface IRankingService {
    public RankingDto gravarRanking(RankingDto rankingDto);

    public List<RankingDto> listRanking();

    public RankingDto editar(RankingDto rankingDto);

    public List<RankingDto> findAllOrderByPuntosDesc();
}
