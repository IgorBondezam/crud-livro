package com.igorfranca.livros.mapper;

import com.igorfranca.livros.domain.Livro;
import com.igorfranca.livros.dto.LivroDTO;

public class LivroMapper {

    public static LivroDTO toDto(Livro livro) {
        LivroDTO livroDTO = new LivroDTO();
        livroDTO.setId(livro.getId());
        livroDTO.setNome(livro.getNome());
        livroDTO.setAutor(livro.getAutor());
        livroDTO.setStatus(livro.getStatus());
        return livroDTO;
    }

    public static Livro toEntity(LivroDTO livroDTO) {
        Livro livro = new Livro();
        livro.setId(livroDTO.getId());
        livro.setNome(livroDTO.getNome());
        livro.setAutor(livroDTO.getAutor());
        livro.setStatus(livroDTO.getStatus());
        return livro;
    }
}
