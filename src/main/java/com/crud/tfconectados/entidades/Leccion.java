package com.crud.tfconectados.entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Leccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true)
    private String titulo;
    private String contenido;
    private String videoUrl;

    @ManyToOne
    @JoinColumn(name = "id_curso", nullable = false)
    private Curso curso;
}
