package com.thiagoalencar.socialexperiment.mappers;

import com.thiagoalencar.socialexperiment.domain.Usuario;
import com.thiagoalencar.socialexperiment.dtos.request.CadastroUsuarioRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UsuarioMapper {
    UsuarioMapper INSTANCE = Mappers.getMapper(UsuarioMapper.class);

    Usuario mapFrom(CadastroUsuarioRequest cadastroUsuarioRequest);
}