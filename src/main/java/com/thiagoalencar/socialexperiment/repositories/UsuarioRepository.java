package com.thiagoalencar.socialexperiment.repositories;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UsuarioRepository {

    private Map<String, Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new java.util.HashMap<>();
    }

    public Usuario cadastrar(Usuario usuario) {
        usuarios.put(usuario.getEmail(), usuario);
        return usuario;
    }

    public Usuario buscar(String id) {
        return usuarios.get(id);
    }
}