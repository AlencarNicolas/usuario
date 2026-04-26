package com.javanauta.usuario.business;

import com.javanauta.usuario.business.converter.UsuarioConverter;
import com.javanauta.usuario.business.dto.UsuarioDTO;
import com.javanauta.usuario.entity.Usuario;
import com.javanauta.usuario.infrastructure.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioConverter usuarioConverter;

    //recebe um objeto usuarioDTO (encriptado)
    public UsuarioDTO salvaUsuario(UsuarioDTO usuarioDTO){
        //converte o usuarioDTO para uma usuario entity
        Usuario usuario = usuarioConverter.paraUsuario(usuarioDTO);
        //RECEBA essa entity e reconverte para DTO e salva esse usuario no repository
        return usuarioConverter.paraUsuarioDTO(
                usuarioRepository.save(usuario)
        );
    }

}
