package com.carteiradesafio.carteiraapi.services;

import br.com.caelum.stella.validation.CNPJValidator;
import br.com.caelum.stella.validation.CPFValidator;
import com.carteiradesafio.carteiraapi.dto.UserDTO;
import com.carteiradesafio.carteiraapi.exceptions.CPFException;
import com.carteiradesafio.carteiraapi.exceptions.EmailException;
import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import com.carteiradesafio.carteiraapi.models.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public void create(Usuario usuario) {
        boolean cpf = validaCpf(usuario);
        boolean cnpj = validaCnpj(usuario);
        boolean verificacaoCpf = verificaCpf(usuario);
        boolean vericacaoEmail = verificaEmail(usuario);
        if (!cpf || !verificacaoCpf) {
            if (!cnpj || !verificacaoCpf){
            throw new CPFException();}
        }else if (!vericacaoEmail) {
            throw new EmailException();
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

    public UserDTO procurar(long id) {
        if (usuarioRepository.findById(id) == null) {
            throw new RuntimeException("Usuario não existe");
        }

        Usuario usuario1 = usuarioRepository.findById(id);

        return new UserDTO(usuario1.getId(), usuario1.getNome(), usuario1.getCpf(), usuario1.getEmail());
    }

    public void atualizar(Usuario usuario) {
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

    public boolean verificaCpf(Usuario usuario){
        List<Usuario> listaUsuario = usuarioRepository.findAll();

        List<String> listaCpf = new ArrayList<>();
        listaUsuario.forEach(usuario1 -> listaCpf.add(usuario1.getCpf()));

        boolean validacao = listaCpf.contains(usuario.getCpf());
        if (validacao){
            throw new CPFException();
        }
        return true;
    }

    public boolean verificaEmail(Usuario usuario){
        List<Usuario> listaUsuario = usuarioRepository.findAll();

        List<String> listaEmail = new ArrayList<>();
        listaUsuario.forEach(usuario1 -> listaEmail.add(usuario1.getEmail()));

        boolean validacao = listaEmail.contains(usuario.getEmail());
        if (validacao){
            throw new EmailException();
        }
        return true;
    }

    public static boolean validaCnpj(Usuario usuario) {
        CNPJValidator cnpjValidator = new CNPJValidator();
        try {
            cnpjValidator.assertValid(usuario.getCpf());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
