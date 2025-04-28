package com.thiagoalencar.socialexperiment.validators;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import com.thiagoalencar.socialexperiment.exceptions.ValidacaoLogicaException;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CadastroUsuarioValidatorTest {

    private CadastroUsuarioValidator validator;

    private Usuario usuario;

    @BeforeEach
    public void setup() {
        validator = new CadastroUsuarioValidator();
        usuario = Instancio.of(Usuario.class).create();
    }


    @Test
    public void testSuccess() {
        validator.validate(usuario);
    }

    @Test
    public void testNomeRequired() {
        usuario.setNome(null);

        final Throwable throwable = catchThrowable(() -> validator.validate(usuario));

        assertThat(throwable, notNullValue());
        assertThat(throwable, instanceOf(ValidacaoLogicaException.class));

        final ValidacaoLogicaException exception = (ValidacaoLogicaException) throwable;
        assertThat(exception.getMessage(), equalTo("O campo nome é obrigatório!"));
    }

    @Test
    public void testGeneroRequired() {
        usuario.setGenero(null);

        final Throwable throwable = catchThrowable(() -> validator.validate(usuario));

        assertThat(throwable, notNullValue());
        assertThat(throwable, instanceOf(ValidacaoLogicaException.class));

        final ValidacaoLogicaException exception = (ValidacaoLogicaException) throwable;
        assertThat(exception.getMessage(), equalTo("O campo gênero é obrigatório!"));
    }

    @Test
    public void testDataNascimentoRequired() {
        usuario.setDataNascimento(null);

        final Throwable throwable = catchThrowable(() -> validator.validate(usuario));

        assertThat(throwable, notNullValue());
        assertThat(throwable, instanceOf(ValidacaoLogicaException.class));

        final ValidacaoLogicaException exception = (ValidacaoLogicaException) throwable;
        assertThat(exception.getMessage(), equalTo("O campo data de nascimento é obrigatório!"));
    }

    @Test
    public void testEmailRequired() {
        usuario.setEmail(null);

        final Throwable throwable = catchThrowable(() -> validator.validate(usuario));

        assertThat(throwable, notNullValue());
        assertThat(throwable, instanceOf(ValidacaoLogicaException.class));

        final ValidacaoLogicaException exception = (ValidacaoLogicaException) throwable;
        assertThat(exception.getMessage(), equalTo("O campo email é obrigatório!"));
    }

    @Test
    public void testSenhaRequired() {
        usuario.setSenha(null);

        final Throwable throwable = catchThrowable(() -> validator.validate(usuario));

        assertThat(throwable, notNullValue());
        assertThat(throwable, instanceOf(ValidacaoLogicaException.class));

        final ValidacaoLogicaException exception = (ValidacaoLogicaException) throwable;
        assertThat(exception.getMessage(), equalTo("O campo senha é obrigatório!"));
    }
}