package com.microservices.microservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices.entities.Pessoa;
import com.microservices.microservices.repository.PessoaRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaRepository repository;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody Pessoa pessoa) {
        // TODO: process POST request

        return pessoa;
    }

}