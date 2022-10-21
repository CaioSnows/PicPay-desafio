package com.picpaydesafio.picpaydesafioback.repository;

import com.picpaydesafio.picpaydesafioback.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //JPARepository possui métodos de persistência de dados


}
