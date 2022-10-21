package com.carteiradesafio.carteiraapi.repository;

import com.carteiradesafio.carteiraapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //JPARepository possui métodos de persistência de dados


}
