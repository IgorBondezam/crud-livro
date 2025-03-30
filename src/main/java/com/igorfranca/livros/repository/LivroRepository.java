package com.igorfranca.livros.repository;

import com.igorfranca.livros.domain.Livro;
import com.igorfranca.livros.enums.StatusLivro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByStatus(StatusLivro status);
}