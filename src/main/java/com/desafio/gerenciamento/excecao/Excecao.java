package com.desafio.gerenciamento.excecao;

import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class Excecao extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest wr) {
        MessagemErro erro = new MessagemErro();
        erro.setDataAtual(LocalDateTime.now());
        erro.setMensagem(ex.getMessage());
        return new ResponseEntity<>(erro, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Data
    class MessagemErro {
        private LocalDateTime dataAtual;
        private String mensagem;
    }

}
