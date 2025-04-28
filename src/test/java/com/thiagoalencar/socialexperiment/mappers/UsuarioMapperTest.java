package com.thiagoalencar.socialexperiment.mappers;

import com.thiagoalencar.socialexperiment.dtos.request.CadastroUsuarioRequest;
import org.instancio.Instancio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class UsuarioMapperTest {

    private CadastroUsuarioRequest source;

    @BeforeEach
    public void setup() {
        source = Instancio.of(CadastroUsuarioRequest.class).create();
    }

    @Test
    public void testMapFrom() {
        final var target = UsuarioMapper.INSTANCE.mapFrom(source);

        assertThat(target, notNullValue());
        assertThat(target.getNome(), equalTo(source.getNome()));
        assertThat(target.getGenero(), equalTo(source.getGenero()));
        assertThat(target.getDataNascimento(), equalTo(source.getDataNascimento()));
        assertThat(target.getEmail(), equalTo(source.getEmail()));
        assertThat(target.getSenha(), equalTo(source.getSenha()));
    }

}