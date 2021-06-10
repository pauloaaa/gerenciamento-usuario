package com.desafio.gerenciamento.validacao;

import com.desafio.gerenciamento.excecao.ExcecaoGeral;

public class Validar {

    public static void validarNome(String nome) throws ExcecaoGeral {
        if (nome == null || "".equals(nome)) {
            throw new ExcecaoGeral("Nome é obrigatório!");
        }
    }

    public static void validarCpf(String cpf) throws ExcecaoGeral {

        if (cpf == null || "".equals(cpf)) {
            throw new ExcecaoGeral("CPF é obrigatório!");
        }

        if (cpf.length() != 11) {
            throw new ExcecaoGeral("CPF inválido!");
        }
    }

}
