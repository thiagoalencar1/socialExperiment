package com.thiagoalencar.socialexperiment.repositories;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioRepositoryTest {

    @InjectMocks
    private UsuarioRepository repository;

    @Mock
    private Map<String, Usuario> dbUsuario;

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        usuario = Instancio.of(Usuario.class).create();
    }

    @Test
    public void testCadastrar() {
        when(dbUsuario.put(anyString(),any(Usuario.class))).thenReturn(usuario);

        final var usuarioCadastrado = repository.cadastrar(usuario);

        verify(dbUsuario, times(1)).put(anyString(),any(Usuario.class));

        assertThat(usuarioCadastrado, notNullValue());
        assertThat(usuarioCadastrado.getNome(), equalTo(usuario.getNome()));
        assertThat(usuarioCadastrado.getDataNascimento(), equalTo(usuario.getDataNascimento()));
        assertThat(usuarioCadastrado.getGenero(), equalTo(usuario.getGenero()));
        assertThat(usuarioCadastrado.getEmail(), equalTo(usuario.getEmail()));
        assertThat(usuarioCadastrado.getSenha(), equalTo(usuario.getSenha()));
    }

    @Test
    public void testBuscar() {
        final var id = usuario.getEmail();

        when(dbUsuario.get(id)).thenReturn(usuario);

        final var usuarioCadastrado = repository.buscar(id);

        verify(dbUsuario, times(1)).get(anyString());

        assertThat(usuarioCadastrado, notNullValue());
        assertThat(usuarioCadastrado.getNome(), equalTo(usuario.getNome()));
        assertThat(usuarioCadastrado.getDataNascimento(), equalTo(usuario.getDataNascimento()));
        assertThat(usuarioCadastrado.getGenero(), equalTo(usuario.getGenero()));
        assertThat(usuarioCadastrado.getEmail(), equalTo(usuario.getEmail()));
        assertThat(usuarioCadastrado.getSenha(), equalTo(usuario.getSenha()));
    }
}
