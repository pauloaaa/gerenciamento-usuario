package com.desafio.gerenciamento.api.controladores;

import com.desafio.gerenciamento.excecao.ExcecaoNaoEncontrado;
import com.desafio.gerenciamento.modelos.Usuario;
import com.desafio.gerenciamento.repositorio.CargoRepositorio;
import com.desafio.gerenciamento.repositorio.UsuarioRepostiorio;
import com.desafio.gerenciamento.validacao.Validar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UsuarioApiControlador {

    @Autowired
    private UsuarioRepostiorio usuarioRepostiorio;

    @Autowired
    private CargoRepositorio cargoRepositorio;

    @GetMapping("/usuario")
    public ResponseEntity<?> listar() {
        return new ResponseEntity<>(usuarioRepostiorio.findAll(), HttpStatus.OK);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<?> carregar(@PathVariable("id") int id) {
        usuarioNaoEncontrado(id);
        return new ResponseEntity<>(usuarioRepostiorio.findById(id), HttpStatus.OK);
    }

    @PostMapping("/usuario")
    public ResponseEntity<?> cadastrar(@RequestBody Usuario usuario) {
        Validar.validarNome(usuario.getNome());
        Validar.validarCpf(usuario.getCpf());
        cargoNaoEncontrado(usuario.getCargo().getId());
        return new ResponseEntity<>(usuarioRepostiorio.save(usuario), HttpStatus.CREATED);
    }

    @PutMapping("/usuario")
    public ResponseEntity<?> alterar(@RequestBody Usuario usuario) {
        usuarioNaoEncontrado(usuario.getId());
        Validar.validarNome(usuario.getNome());
        cargoNaoEncontrado(usuario.getCargo().getId());
        return new ResponseEntity<>(usuarioRepostiorio.save(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> remover(@PathVariable("id") int id) {
        usuarioNaoEncontrado(id);
        usuarioRepostiorio.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private void usuarioNaoEncontrado(int id) {
        if (!usuarioRepostiorio.findById(id).isPresent())
            throw new ExcecaoNaoEncontrado("Usuário não encontrado!");
    }

    private void cargoNaoEncontrado(int id) {
        if (!cargoRepositorio.findById(id).isPresent())
            throw new ExcecaoNaoEncontrado("Cargo não encontrado!");
    }
}
