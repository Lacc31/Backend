package com.crud.tfconectados.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CursoDto implements Serializable {
    Long id;
    private String nombreCurso;
    private String descripcion;
    private String dificultad;

    ;
}
