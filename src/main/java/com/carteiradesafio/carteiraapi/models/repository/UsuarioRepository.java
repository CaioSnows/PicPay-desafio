package com.carteiradesafio.carteiraapi.models.repository;

import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //JPARepository possui métodos de persistência de dados

    public Optional<Usuario> findById(long id);

}
