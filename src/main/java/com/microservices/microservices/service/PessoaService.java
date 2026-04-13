package com.microservices.microservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.microservices.entities.Pessoa;
import com.microservices.microservices.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public ResponseEntity<String> cadastrar(Pessoa pessoa) {
        repository.save(pessoa);
        return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.OK);
    }

}
