package com.thiagoalencar.socialexperiment.controllers;

import com.thiagoalencar.socialexperiment.dtos.request.CadastroUsuarioRequest;
import com.thiagoalencar.socialexperiment.dtos.response.CadastroUsuarioResponse;
import com.thiagoalencar.socialexperiment.mappers.UsuarioMapper;
import com.thiagoalencar.socialexperiment.services.CadastrarUsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CadastroController {

    private final CadastrarUsuarioService cadastrarUsuarioService;

    public CadastroController(CadastrarUsuarioService cadastrarUsuarioService) {
        this.cadastrarUsuarioService = cadastrarUsuarioService;
    }

    @PostMapping("cadastrar")
    public ResponseEntity<CadastroUsuarioResponse> cadastrar(@RequestBody CadastroUsuarioRequest request) {
        final var usuario = UsuarioMapper.INSTANCE.mapFrom(request);
        cadastrarUsuarioService.cadastrar(usuario);
        final var response = CadastroUsuarioResponse.builder()
                .mensagem("Cadastro realizado com sucesso!")
                .build();
        return ResponseEntity.ok().body(response);
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