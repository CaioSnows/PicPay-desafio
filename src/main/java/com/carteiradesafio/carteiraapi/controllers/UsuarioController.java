package com.carteiradesafio.carteiraapi.controllers;

import com.carteiradesafio.carteiraapi.models.Usuario;
import com.carteiradesafio.carteiraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api") // Criando um URL
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/usuario")
    public List<Usuario> listaUsuarios(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario listaUsuarioUnico(@PathVariable(value = "id") long id){
        return usuarioRepository.findById(id);
    }

    @PostMapping("/usuario")
    public Usuario salvaUsuario(@RequestBody Usuario usuario){ // Receber o usuario como JSON no corpo da requisição
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/usuario")
    public void deletaUsuario(@RequestBody Usuario usuario){
        usuarioRepository.delete(usuario);
    }

    @PutMapping("/usuario")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
