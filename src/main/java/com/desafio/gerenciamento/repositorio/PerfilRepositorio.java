package com.desafio.gerenciamento.repositorio;

import com.desafio.gerenciamento.modelos.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepositorio extends JpaRepository<Perfil, Integer> {
}
