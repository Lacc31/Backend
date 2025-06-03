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
public class RankingDto implements Serializable {

    Long id;

    int puntos;

    UsuarioDto usuario;
}
