package com.microservices.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices.entities.Pessoa;
import com.microservices.microservices.repository.PessoaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody Pessoa pessoa) {
        repository.save(pessoa);
        return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.OK);
    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Pessoa>> listarTodos() {
        List<Pessoa> pessoas = repository.findAll();
        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        repository.deleteById(id);
        return new ResponseEntity<>("A pessoa com o ID " + id + " foi excluido com sucesso!", HttpStatus.OK);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable int id, @RequestBody Pessoa pessoaAtualizada) {
        if (repository.existsById(id)) {
            pessoaAtualizada.setId(id);
            repository.save(pessoaAtualizada);
            return new ResponseEntity<>("A pessoa com o ID " + id + " foi alterada com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Pessoa não encontrada.", HttpStatus.NOT_FOUND);
        }
    }
}