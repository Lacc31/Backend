package com.crud.tfconectados.controller;

import com.crud.tfconectados.dto.LeccionDto;
import com.crud.tfconectados.servicios.LeccionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/leccion")
public class LeccionController {
    @Autowired
    private LeccionService leccionService;

    @PostMapping("/grabar")
    public ResponseEntity<LeccionDto> grabarLeccion(@RequestBody LeccionDto leccionDto) {
        return ResponseEntity.ok(leccionService.grabarLeccion(leccionDto));
    }

    @GetMapping("/listar")
    public List<LeccionDto> listarLeccion() {
        log.info("Lista de las lecciones");
        return leccionService.listLecciones();
    }

    @PutMapping("/editar")
    public ResponseEntity<LeccionDto> editarProveedor(@RequestBody LeccionDto leccion) {
        return ResponseEntity.ok(leccionService.editar(leccion));
    }
}
