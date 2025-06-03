package com.crud.tfconectados.controller;

import com.crud.tfconectados.dto.RankingDto;
import com.crud.tfconectados.servicios.RankingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/ranking")
public class RankingController {
    @Autowired
    private RankingService rankingService;

    @PostMapping("/grabar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<RankingDto> grabarRanking(@RequestBody RankingDto rankingdto) {
        return ResponseEntity.ok(rankingService.gravarRanking(rankingdto));
    }

    @PutMapping("/editar")
    public ResponseEntity<RankingDto> editarRanking(@RequestBody RankingDto ranking) {
        return ResponseEntity.ok(rankingService.editar(ranking));
    }

    @GetMapping("/listar")
    public List<RankingDto> listarRanking() {
        log.info("Lista del rank");
        return rankingService.listRanking();
    }

    @GetMapping("/Listado")
    public List<RankingDto> ListadoRanking() {
        log.info("Lista del rank");
        return rankingService.findAllOrderByPuntosDesc();
    }
}
