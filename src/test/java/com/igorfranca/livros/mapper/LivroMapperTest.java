package com.igorfranca.livros.mapper;

import com.igorfranca.livros.domain.Livro;
import com.igorfranca.livros.dto.LivroDTO;
import com.igorfranca.livros.enums.StatusLivro;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LivroMapperTest {

    @Test
    public void deveConverterLivroParaLivroDTO() {
        Livro livro = new Livro(1L, "NomeLivro", "NomeAutor", StatusLivro.DISPONIVEL);

        LivroDTO result = LivroMapper.toDto(livro);

        assertEquals(1L, result.getId());
        assertEquals("NomeLivro", result.getNome());
        assertEquals("NomeAutor", result.getAutor());
        assertEquals(StatusLivro.DISPONIVEL, result.getStatus());
    }
}
