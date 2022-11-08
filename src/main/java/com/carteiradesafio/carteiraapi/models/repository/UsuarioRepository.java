package com.carteiradesafio.carteiraapi.models.repository;

import com.carteiradesafio.carteiraapi.models.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> { //JPARepository possui métodos de persistência de dados

    public Usuario findById(long id);
    public boolean findByCpf(String cpf);

}
