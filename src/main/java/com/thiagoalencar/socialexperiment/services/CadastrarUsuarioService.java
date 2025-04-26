package com.thiagoalencar.socialexperiment.services;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import com.thiagoalencar.socialexperiment.exceptions.ValidacaoDeNegocioException;
import com.thiagoalencar.socialexperiment.repositories.UsuarioRepository;
import com.thiagoalencar.socialexperiment.validators.CadastroUsuarioValidator;
import org.springframework.stereotype.Service;

@Service
public class CadastrarUsuarioService {

    private final CadastroUsuarioValidator cadastroUsuarioValidator;
    private final UsuarioRepository usuarioRepository;

    public CadastrarUsuarioService(CadastroUsuarioValidator cadastroUsuarioValidator,
                                   UsuarioRepository usuarioRepository) {
        this.cadastroUsuarioValidator = cadastroUsuarioValidator;
        this.usuarioRepository = usuarioRepository;
    }

    public void cadastrar(Usuario usuario) {
        cadastroUsuarioValidator.validate(usuario);
        final Usuario usuarioEncontrado = usuarioRepository.buscar(usuario.getEmail());
        if(usuarioEncontrado != null) {
            throw new ValidacaoDeNegocioException("Usuário já cadastrado!");
        }
        usuarioRepository.cadastrar(usuario);
    }
}