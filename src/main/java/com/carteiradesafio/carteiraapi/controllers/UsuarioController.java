package com.carteiradesafio.carteiraapi.controllers;

import com.carteiradesafio.carteiraapi.dto.UserDTO;
import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import com.carteiradesafio.carteiraapi.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/usuario")
    public List<UserDTO> listarUsuarios() {
        return usuarioService.listaDeUsuarios();
    }


    @GetMapping("/usuario/{id}")
    public UserDTO usuarioUnico(@PathVariable(value = "id") long id) {
        return usuarioService.procurar(id);
    }

    @PostMapping("/usuario")
    public void salvarUsuario(@RequestBody Usuario usuario) { // Receber o usuário como JSON no corpo da requisição
         usuarioService.create(usuario);
    }

    @DeleteMapping(path = "/usuario/{id}")
    public void deletarUsuario(@PathVariable long id) {
        UserDTO usuario = usuarioService.procurar(id);
        if(usuario != null){
            usuarioService.delete(id);
        }else {
            throw new RuntimeException();
        }
    }

    @PutMapping("/usuario")
    public void atualizarUsuario(@RequestBody Usuario usuario) {
        UserDTO usuario1 = usuarioService.procurar(usuario.getId());
        if (usuario1 != null){
             usuarioService.atualizar(usuario);
        } else {
            throw new RuntimeException();
        }
    }
}
