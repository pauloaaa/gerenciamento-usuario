package com.desafio.gerenciamento.repositorio;

import com.desafio.gerenciamento.modelos.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepositorio extends JpaRepository<Cargo, Integer> {

}
