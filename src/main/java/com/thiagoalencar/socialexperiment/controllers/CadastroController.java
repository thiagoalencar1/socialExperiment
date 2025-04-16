package com.thiagoalencar.socialexperiment.controllers;

import com.thiagoalencar.socialexperiment.services.CadastrarUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CadastroController {

    @Autowired
    private CadastrarUsuarioService cadastrarUsuarioService;

    @PostMapping("cadastrar")
    public String cadastrar() {
        cadastrarUsuarioService.cadastrar();
        return "Cadastro realizado com sucesso!";
    }

    @GetMapping("consultar")
    public String consultar() {
        return "Consulta realizada com sucesso!";
    }

    @PatchMapping("alterar")
    public String alterar() {
        return "Alteração realizada com sucesso!";
    }

    @DeleteMapping("excluir")
    public String excluir() {
        return "Exclusão realizada com sucesso!";
    }
}