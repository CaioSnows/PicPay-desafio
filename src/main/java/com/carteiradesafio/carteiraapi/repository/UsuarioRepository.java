package com.picpaydesafio.carteiraapi.repository;

import com.picpaydesafio.carteiraapi.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //JPARepository possui métodos de persistência de dados


}
