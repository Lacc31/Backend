package com.crud.tfconectados.controller;

import com.crud.tfconectados.dto.LogroDto;
import com.crud.tfconectados.servicios.LogroService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/logro")
public class LogroController {
    @Autowired
    private LogroService logroService;

    @PostMapping("/grabar")
    public ResponseEntity<LogroDto> grabarLogro(@RequestBody LogroDto logroDto) {
        return ResponseEntity.ok(logroService.grabarLogro(logroDto));
    }

    @GetMapping("/listar")
    public List<LogroDto> listarLogro() {
        log.info("Lista de los logros");
        return logroService.listLogro();
    }

    @PutMapping("/editar")
    public ResponseEntity<LogroDto> editarLogro(@RequestBody LogroDto logro) {
        return ResponseEntity.ok(logroService.editar(logro));
    }
}

