package com.thiagoalencar.socialexperiment.validators;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import com.thiagoalencar.socialexperiment.exceptions.ValidacaoLogicaException;
import org.springframework.stereotype.Component;

@Component
public class CadastroUsuarioValidator {

    public void validate(Usuario usuario) {
        if (usuario.getNome() == null) {
            throw new ValidacaoLogicaException("O campo nome é obrigatório!");
        }
        if (usuario.getEmail() == null) {
            throw new ValidacaoLogicaException("O campo email é obrigatório!");
        }
        if (usuario.getSenha() == null) {
            throw new ValidacaoLogicaException("O campo senha é obrigatório!");
        }
        if (usuario.getGenero() == null) {
            throw new ValidacaoLogicaException("O campo gênero é obrigatório!");
        }
        if (usuario.getDataNascimento() == null) {
            throw new ValidacaoLogicaException("O campo data de nascimento é obrigatório!");
        }
    }
}