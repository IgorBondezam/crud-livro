package com.igorfranca.livros.service;

import com.igorfranca.livros.domain.Livro;
import com.igorfranca.livros.enums.StatusLivro;
import com.igorfranca.livros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> getLivrosByStatus(StatusLivro status) {
        return livroRepository.findByStatus(status);
    }

    public Livro updateLivroStatus(Long id, StatusLivro status) {
        Livro livroUpdate = livroRepository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado " + id));
        livroUpdate.setStatus(status);
        return livroRepository.save(livroUpdate);
    }

    public Livro createLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> getAllLivros() {
        return livroRepository.findAll();
    }

    public Livro getLivroById(Long id) {
        return livroRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Livro não encontrado " + id));
    }

    public Livro updateLivro(Long id, Livro livro) {
        Livro livroSave = livroRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Livro não encontrado " + id));
        livroSave.setNome(livro.getNome());
        livroSave.setAutor(livro.getAutor());
        return livroRepository.save(livroSave);
    }

    public void deleteLivro(Long id) {
        livroRepository.deleteById(id);
    }
}