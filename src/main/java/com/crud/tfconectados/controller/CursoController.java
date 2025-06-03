package com.crud.tfconectados.controller;

import com.crud.tfconectados.dto.CursoDto;
import com.crud.tfconectados.servicios.CursoService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/grabar")
    public ResponseEntity<CursoDto> grabarCurso(@RequestBody CursoDto cursoDto) {
        return ResponseEntity.ok(cursoService.grabarCurso(cursoDto));
    }

    @GetMapping("/listar")
    public List<CursoDto> listarCursos() {
        log.info("Lista de las cursos");
        return cursoService.listarCursos();
    }

    @PutMapping("/editar")
    public ResponseEntity<CursoDto> editarProveedor(@RequestBody CursoDto curso) {
        return ResponseEntity.ok(cursoService.editar(curso));
    }
}
