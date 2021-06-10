package com.desafio.gerenciamento.excecao;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExcecaoNaoEncontrado extends RuntimeException {

    public ExcecaoNaoEncontrado(String message) {
        super(message);
    }
}
