package com.biblioteca.controller;

import com.biblioteca.model.Livro;
import com.biblioteca.repository.LivroRepository;
import com.biblioteca.exception.LivroNaoEncontradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private static final Logger logger = LoggerFactory.getLogger(LivroController.class);

    @Autowired
    private LivroRepository livroRepository;

    @GetMapping
    public List<Livro> listarLivros() {
        logger.info("Listando todos os livros...");
        return livroRepository.findAll();
    }

    @PostMapping
    public Livro adicionarLivro(@RequestBody Livro livro) {
        logger.info("Adicionando um novo livro...");
        return livroRepository.save(livro);
    }

    @PutMapping("/{id}")
    public Livro atualizarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        logger.info("Atualizando livro com ID {}", id);
        if (!livroRepository.existsById(id)) {
            throw new LivroNaoEncontradoException("Livro com ID " + id + " não encontrado");
        }
        livro.setId(id);
        return livroRepository.save(livro);
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id) {
        logger.info("Deletando livro com ID {}", id);
        if (!livroRepository.existsById(id)) {
            throw new LivroNaoEncontradoException("Livro com ID " + id + " não encontrado");
        }
        livroRepository.deleteById(id);
    }
}
