package com.desafio.gerenciamento.repositorio;

import com.desafio.gerenciamento.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepostiorio extends JpaRepository<Usuario, Integer> {

}
