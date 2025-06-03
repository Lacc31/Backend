package com.crud.tfconectados.controller;


import com.crud.tfconectados.dto.ProgresoCursoUsuarioDto;
import com.crud.tfconectados.servicios.ProgresoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/progreso")
public class ProgresoController {
    @Autowired
    private ProgresoService progresoService;

    @PostMapping("/grabar")
    public ResponseEntity<ProgresoCursoUsuarioDto> grabarProgresoCursoUsuario(@RequestBody ProgresoCursoUsuarioDto progresoDto) {
        return ResponseEntity.ok(progresoService.grabarProgresoCursoUsuario(progresoDto));
    }

    @GetMapping("/listar")
    public List<ProgresoCursoUsuarioDto> listarProgreso() {
        log.info("Lista de los progresos");
        return progresoService.listProgreso();
    }

    @PutMapping("/editar")
    public ResponseEntity<ProgresoCursoUsuarioDto> editarProgreso(@RequestBody ProgresoCursoUsuarioDto progreso) {
        return ResponseEntity.ok(progresoService.editar(progreso));
    }
}
