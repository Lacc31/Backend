package com.crud.tfconectados.servicios;

import com.crud.tfconectados.dto.RankingDto;
import com.crud.tfconectados.entidades.Ranking;
import com.crud.tfconectados.interfaces.IRankingService;
import com.crud.tfconectados.repositorios.RankingRepositorio;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RankingService implements IRankingService {
    @Autowired
    private RankingRepositorio rankingRepositorio;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public RankingDto gravarRanking(RankingDto rankingDto) {
        Ranking ranking = modelMapper.map(rankingDto, Ranking.class);
        Ranking guardar = rankingRepositorio.save(ranking);

        return modelMapper.map(guardar, RankingDto.class);
    }

    @Override
    public List<RankingDto> listRanking() {
        return rankingRepositorio.findAll().stream().map(ranking -> modelMapper.map(ranking, RankingDto.class)).collect(Collectors.toList());
    }

    @Override
    public RankingDto editar(RankingDto ranking) {
        if (rankingRepositorio.findById(ranking.getId()).isPresent()) {
            Ranking rankingEntidad = modelMapper.map(ranking, Ranking.class);
            Ranking guardar = rankingRepositorio.save(rankingEntidad);
            return modelMapper.map(guardar, RankingDto.class);

        }
        return null;
    }

    @Override
    public List<RankingDto> findAllOrderByPuntosDesc() {

        List<Ranking> rankingEntidades = rankingRepositorio.findAllByOrderByPuntosDesc();
        return rankingEntidades.stream().map(r -> modelMapper.map(r, RankingDto.class)).collect(Collectors.toList());
    }
}
