package com.carteiradesafio.carteiraapi.controllers;

import com.carteiradesafio.carteiraapi.dto.UserDTO;
import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import com.carteiradesafio.carteiraapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api") // Criando um URL
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<UserDTO> listarUsuarios() {
        return usuarioService.listaDeUsuarios();
    }


    @GetMapping("/usuario/{id}")
    public Optional<Usuario> usuarioUnico(@PathVariable(value = "id") long id) {
        return usuarioService.procurar(id);
    }

    @PostMapping("/usuario")
    public void salvarUsuario(@RequestBody Usuario usuario) { // Receber o usuário como JSON no corpo da requisição
         usuarioService.create(usuario);
    }

    @DeleteMapping(path = "/usuario/{id}")
    public void deletarUsuario(@PathVariable long id) { // Outra maneira de fazer o que o listaUsuarioUnico @Path faz
        Optional<Usuario> usuario = usuarioService.procurar(id);
        if(usuario.isPresent()){
            usuarioService.delete(id);
        }else {
            throw new RuntimeException();
        }
    }

    @PutMapping("/usuario")
    public void atualizarUsuario(@RequestBody Usuario usuario) {
        Optional<Usuario> usuario1 = usuarioService.procurar(usuario.getId());
        if (usuario1.isPresent()){
             usuarioService.atualizar(usuario);
        } else {
            throw new RuntimeException();
        }
    }
}
