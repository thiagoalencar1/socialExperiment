package com.thiagoalencar.socialexperiment.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String genero;
    private String dataNascimento;
}