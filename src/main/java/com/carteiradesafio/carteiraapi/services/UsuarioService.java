package com.carteiradesafio.carteiraapi.services;

import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import com.carteiradesafio.carteiraapi.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario){
        if(usuario.getCpf().length() != 11){
            throw new RuntimeException("CPF do usuário é invalido");
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaDeUsuarios(){
        return usuarioRepository.findAll();
    }
}
