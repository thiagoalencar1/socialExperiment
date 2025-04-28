package com.thiagoalencar.socialexperiment.services;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import com.thiagoalencar.socialexperiment.exceptions.ValidacaoDeNegocioException;
import com.thiagoalencar.socialexperiment.exceptions.ValidacaoLogicaException;
import com.thiagoalencar.socialexperiment.repositories.UsuarioRepository;
import com.thiagoalencar.socialexperiment.validators.CadastroUsuarioValidator;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CadastrarUsuarioServiceTest {

    @InjectMocks
    private CadastrarUsuarioService service;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private CadastroUsuarioValidator validator;

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        usuario = Instancio.of(Usuario.class).create();
    }

    @Test
    public void testSuccess() {
        doNothing().when(validator).validate(usuario);
        when(repository.buscar(anyString())).thenReturn(null);

        service.cadastrar(usuario);

        verify(validator, times(1)).validate(any(Usuario.class));
        verify(repository, times(1)).buscar(anyString());
        verify(repository, times(1)).cadastrar(any(Usuario.class));
    }

    @Test
    public void testFailValidacaoLogica() {
        doThrow(ValidacaoLogicaException.class).when(validator).validate(usuario);

        final var throwable = catchThrowable(() -> service.cadastrar(usuario));

        assertThat(throwable, notNullValue());
        assertThat(throwable, instanceOf(ValidacaoLogicaException.class));

        verify(validator, times(1)).validate(any(Usuario.class));
        verify(repository, times(0)).buscar(anyString());
        verify(repository, times(0)).cadastrar(any(Usuario.class));
    }

    @Test
    public void testFailValidacaoDeNegocio() {
        doNothing().when(validator).validate(usuario);
        when(repository.buscar(anyString())).thenReturn(usuario);

        final var throwable = catchThrowable(() -> service.cadastrar(usuario));

        assertThat(throwable, notNullValue());
        assertThat(throwable, instanceOf(ValidacaoDeNegocioException.class));

        verify(validator, times(1)).validate(any(Usuario.class));
        verify(repository, times(1)).buscar(anyString());
        verify(repository, times(0)).cadastrar(any(Usuario.class));
    }
}