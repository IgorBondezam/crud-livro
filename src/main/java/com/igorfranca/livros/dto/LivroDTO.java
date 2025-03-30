package com.igorfranca.livros.dto;

import com.igorfranca.livros.enums.StatusLivro;

public class LivroDTO {
    private Long id;
    private String nome;
    private String autor;
    private StatusLivro status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status;
    }
}