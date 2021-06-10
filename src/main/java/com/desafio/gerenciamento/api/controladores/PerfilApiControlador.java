package com.desafio.gerenciamento.api.controladores;

import com.desafio.gerenciamento.excecao.ExcecaoGeral;
import com.desafio.gerenciamento.excecao.ExcecaoNaoEncontrado;
import com.desafio.gerenciamento.modelos.Perfil;
import com.desafio.gerenciamento.repositorio.PerfilRepositorio;
import com.desafio.gerenciamento.validacao.Validar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PerfilApiControlador {

    @Autowired
    PerfilRepositorio perfilRepositorio;

    @GetMapping("/perfil")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(perfilRepositorio.findAll(), HttpStatus.OK);
    }

    @GetMapping("/perfil/{id}")
    public ResponseEntity<?> carregar(@PathVariable("id") int id) {
        perfilNaoEncontrado(id);
        return new ResponseEntity<>(perfilRepositorio.findById(id), HttpStatus.OK);
    }

    @PostMapping("/perfil")
    public ResponseEntity<?> cadastrar(@RequestBody Perfil perfil) throws ExcecaoGeral {
        Validar.validarNome(perfil.getNome());
        return new ResponseEntity<>(perfilRepositorio.save(perfil), HttpStatus.CREATED);
    }

    @PutMapping("/perfil")
    public ResponseEntity<?> alterar(@RequestBody Perfil perfil) {
        perfilNaoEncontrado(perfil.getId());
        Validar.validarNome(perfil.getNome());
        return new ResponseEntity<>(perfilRepositorio.save(perfil), HttpStatus.CREATED);
    }

    @DeleteMapping("/perfil/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") int id) {
        perfilNaoEncontrado(id);
        perfilRepositorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void perfilNaoEncontrado(int id) {
        if(!perfilRepositorio.findById(id).isPresent())
            throw new ExcecaoNaoEncontrado("Perfil não encontrado!");
    }
}
