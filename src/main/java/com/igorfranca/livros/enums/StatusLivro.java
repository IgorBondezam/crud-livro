package com.igorfranca.livros.enums;

public enum StatusLivro {
    EM_EMPRESTIMO("Em Empréstimo"),
    DISPONIVEL("Disponível"),
    RESERVADO("Reservado");

    private final String descricao;

    StatusLivro(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}