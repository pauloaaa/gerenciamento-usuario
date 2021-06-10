package com.desafio.gerenciamento.api.controladores;

import com.desafio.gerenciamento.excecao.ExcecaoNaoEncontrado;
import com.desafio.gerenciamento.modelos.Cargo;
import com.desafio.gerenciamento.repositorio.CargoRepositorio;
import com.desafio.gerenciamento.validacao.Validar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CargoApiControlador {

    @Autowired
    CargoRepositorio cargoRepositorio;

    @GetMapping("/cargo")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(cargoRepositorio.findAll(), HttpStatus.OK);
    }

    @GetMapping("/cargo/{id}")
    public ResponseEntity<?> carregar(@PathVariable("id") int id) {
        cargoNaoEncontrado(id);
        return new ResponseEntity<>(cargoRepositorio.findById(id), HttpStatus.OK);
    }

    @PostMapping("/cargo")
    public ResponseEntity<?> cadastrar(@RequestBody Cargo cargo) {
        Validar.validarNome(cargo.getNome());
        return new ResponseEntity<>(cargoRepositorio.save(cargo), HttpStatus.CREATED);
    }

    @PutMapping("/cargo")
    public ResponseEntity<?> alterar(@RequestBody Cargo cargo) {
        cargoNaoEncontrado(cargo.getId());
        Validar.validarNome(cargo.getNome());
        return new ResponseEntity<>(cargoRepositorio.save(cargo), HttpStatus.CREATED);
    }

    @DeleteMapping("/cargo/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") int id) {
        cargoNaoEncontrado(id);
        cargoRepositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void cargoNaoEncontrado(int id) {
        if (!cargoRepositorio.findById(id).isPresent())
            throw new ExcecaoNaoEncontrado("Cargo não encontrado!");
    }
}
