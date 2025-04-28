package com.thiagoalencar.socialexperiment.repositories;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public class UsuarioRepository {

    private final Map<String, Usuario> dbUsuario;

    public UsuarioRepository(Map<String, Usuario> dbUsuario) {
        this.dbUsuario = Optional.ofNullable(dbUsuario).orElse(new java.util.HashMap<>());
    }

    public Usuario cadastrar(Usuario usuario) {
        return dbUsuario.put(usuario.getEmail(), usuario);
    }

    public Usuario buscar(String id) {
        return dbUsuario.get(id);
    }
}