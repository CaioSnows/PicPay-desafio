package com.carteiradesafio.carteiraapi.services;

import br.com.caelum.stella.validation.CPFValidator;
import com.carteiradesafio.carteiraapi.dto.UserDTO;
import com.carteiradesafio.carteiraapi.excepitons.CPFException;
import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import com.carteiradesafio.carteiraapi.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void create(Usuario usuario) {
        boolean cpf = validaCpf(usuario);
        if (!cpf) {
            throw new NullPointerException();
        }
        usuarioRepository.save(usuario);
    }

    public List<UserDTO> listaDeUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) {
            throw new RuntimeException("Não há usuarios cadastrados");
        }

        List<UserDTO> userDTOS = new ArrayList<>();
        usuarios.forEach(usuario -> userDTOS.add(new UserDTO(usuario.getId(), usuario.getNome(),
                usuario.getCpf(), usuario.getEmail())));

        return userDTOS;
    }

    public void delete(long id) {
        usuarioRepository.deleteById(id);
    }

    public Optional<Usuario> procurar(long id) {
        if (usuarioRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Usuario {id} não existe");
        }
        return usuarioRepository.findById(id);
    }

    public void atualizar(Usuario usuario){
        boolean cpf = validaCpf(usuario);
        if (!cpf) {
            throw new CPFException();
        }
        usuarioRepository.save(usuario);
    }

    public static boolean validaCpf(Usuario usuario) {
        CPFValidator cpfValidator = new CPFValidator();
        try {
            cpfValidator.assertValid(usuario.getCpf());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
