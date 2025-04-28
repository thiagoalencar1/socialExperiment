package com.thiagoalencar.socialexperiment.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thiagoalencar.socialexperiment.domain.Usuario;
import com.thiagoalencar.socialexperiment.dtos.request.CadastroUsuarioRequest;
import com.thiagoalencar.socialexperiment.services.CadastrarUsuarioService;
import org.instancio.Instancio;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CadastroController.class)
public class CadastroControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private CadastrarUsuarioService cadastrarUsuarioService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void testSuccessCadastrarUsuario() throws Exception {
        final var cadastroUsuarioRequest = Instancio.of(CadastroUsuarioRequest.class).create();
        final var json = objectMapper.writeValueAsString(cadastroUsuarioRequest);

        mockMvc.perform(post("/cadastrar")
                        .contentType("application/json")
                        .content(json))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"mensagem\":\"Cadastro realizado com sucesso!\"}"))
        ;

        verify(cadastrarUsuarioService, times(1)).cadastrar(any(Usuario.class));
    }
}