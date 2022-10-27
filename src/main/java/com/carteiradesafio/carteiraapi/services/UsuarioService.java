package com.carteiradesafio.carteiraapi.services;

import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import com.carteiradesafio.carteiraapi.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario create(Usuario usuario){
        if(usuario.getCpf().length() != 11){
            throw new NullPointerException();
        }
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listaDeUsuarios(){
        if(usuarioRepository.findAll().isEmpty()){
            throw new RuntimeException();
        }
        return usuarioRepository.findAll();
    }

    public void delete(long id){
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> procurar(long id){
        if (usuarioRepository.findById(id).isEmpty()){
            throw new RuntimeException();
        }
        return usuarioRepository.findById(id);
    }

    public Usuario atualizar(Usuario usuario){
        if(usuario.getCpf().length() != 11){
            throw new NullPointerException();
        }
        return usuarioRepository.save(usuario);
    }
}
