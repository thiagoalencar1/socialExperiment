package com.thiagoalencar.socialexperiment.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CadastroUsuarioRequest {

    private String nome;
    private String email;
    private String senha;
    private String genero;
    private String dataNascimento;
}