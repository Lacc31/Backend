package com.crud.tfconectados.controller;

import com.crud.tfconectados.dto.InsigniaDto;
import com.crud.tfconectados.servicios.InsigniaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/insignia")
public class InsigniaController {
    @Autowired
    private InsigniaService insigniaService;

    @PostMapping("/grabar")
    public ResponseEntity<InsigniaDto> grabarInsignia(@RequestBody InsigniaDto insigniaDto) {
        return ResponseEntity.ok(insigniaService.grabarInsignia(insigniaDto));
    }

    @GetMapping("/listar")
    public List<InsigniaDto> listarInsignias() {
        log.info("Lista de las insginas");
        return insigniaService.listInsignias();
    }

    @PutMapping("/editar")
    public ResponseEntity<InsigniaDto> editarProveedor(@RequestBody InsigniaDto insignia) {
        return ResponseEntity.ok(insigniaService.editar(insignia));
    }
}
