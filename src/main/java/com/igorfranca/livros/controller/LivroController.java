package com.igorfranca.livros.controller;

        import com.igorfranca.livros.dto.LivroDTO;
        import com.igorfranca.livros.enums.StatusLivro;
        import com.igorfranca.livros.mapper.LivroMapper;
        import com.igorfranca.livros.service.LivroService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import java.util.List;

        @RestController
        @RequestMapping("/api/livros")
        public class LivroController {

            @Autowired
            private LivroService livroService;

            @PostMapping
            public ResponseEntity<LivroDTO> createLivro(@RequestBody LivroDTO livroDTO) {
                LivroDTO createdLivro = LivroMapper.toDto(livroService.createLivro(LivroMapper.toEntity(livroDTO)));
                return ResponseEntity.ok(createdLivro);
            }

            @GetMapping
            public ResponseEntity<List<LivroDTO>> getAllLivros() {
                List<LivroDTO> livros = livroService.getAllLivros().stream().map(LivroMapper::toDto).toList();
                return ResponseEntity.ok(livros);
            }

            @GetMapping("/status/{status}")
            public ResponseEntity<List<LivroDTO>> getLivrosByStatus(@PathVariable StatusLivro status) {
                List<LivroDTO> livros = livroService.getLivrosByStatus(status).stream().map(LivroMapper::toDto).toList();
                return ResponseEntity.ok(livros);
            }

            @GetMapping("/{id}")
            public ResponseEntity<LivroDTO> getLivroById(@PathVariable Long id) {
                LivroDTO livro = LivroMapper.toDto(livroService.getLivroById(id));
                return ResponseEntity.ok(livro);
            }

            @PutMapping("/{id}/status")
            public ResponseEntity<LivroDTO> updateLivroStatus(@PathVariable Long id, @RequestBody StatusLivro status) {
                try {
                    LivroDTO updatedLivro = LivroMapper.toDto(livroService.updateLivroStatus(id, status));
                    return ResponseEntity.ok(updatedLivro);
                } catch (RuntimeException e) {
                    return ResponseEntity.notFound().build();
                }
            }

            @PutMapping("/{id}")
            public ResponseEntity<LivroDTO> updateLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
                try {
                    LivroDTO updatedLivro = LivroMapper.toDto(livroService.updateLivro(id, LivroMapper.toEntity(livroDTO)));
                    return ResponseEntity.ok(updatedLivro);
                } catch (RuntimeException e) {
                    return ResponseEntity.notFound().build();
                }
            }

            @DeleteMapping("/{id}")
            public ResponseEntity<Void> deleteLivro(@PathVariable Long id) {
                livroService.deleteLivro(id);
                return ResponseEntity.noContent().build();
            }
        }