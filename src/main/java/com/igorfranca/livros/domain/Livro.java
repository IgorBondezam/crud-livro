package com.igorfranca.livros.domain;

import com.igorfranca.livros.enums.StatusLivro;
import jakarta.persistence.*;

@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String autor;

    @Enumerated(EnumType.STRING)
    private StatusLivro status = StatusLivro.DISPONIVEL;

    public Livro() {
    }

    public Livro(Long id, String nome, String autor, StatusLivro status) {
        this.id = id;
        this.nome = nome;
        this.autor = autor;
        this.status = status;
    }

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
