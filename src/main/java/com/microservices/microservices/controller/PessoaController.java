package com.microservices.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices.entities.Pessoa;
import com.microservices.microservices.service.PessoaService;

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
    PessoaService service;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody Pessoa pessoa) {
        return service.cadastrar(pessoa);

    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<Pessoa>> listarTodos() {
        return service.listarTodos();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        return service.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable int id, @RequestBody Pessoa pessoaAtualizada) {
        return service.editar(id, pessoaAtualizada);
    }
}