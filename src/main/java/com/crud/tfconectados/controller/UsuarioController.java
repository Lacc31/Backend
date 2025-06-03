package com.crud.tfconectados.controller;


import com.crud.tfconectados.dto.UsuarioDto;
import com.crud.tfconectados.entidades.Usuario;
import com.crud.tfconectados.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/usuario")

public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/listar")
    public List<UsuarioDto> listarUsuarios() {
        log.info("Lista de usuarios");
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/grabar")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UsuarioDto> grabarUsuario(@RequestBody UsuarioDto usuarioDto) {
        return ResponseEntity.ok(usuarioService.grabarUsuario(usuarioDto));
    }

    @PutMapping("/editar")
    public ResponseEntity<UsuarioDto> editarProveedor(@RequestBody UsuarioDto usuario) {
        return ResponseEntity.ok(usuarioService.editar(usuario));
    }

    @GetMapping("/buscar/{id}")
    public Usuario buscarPorId(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }




}
