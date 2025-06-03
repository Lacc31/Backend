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
public class LeccionDto implements Serializable {
    Long id;
    String titulo;
    String contenido;
    String videoUrl;
    LeccionDto leccion;

}
