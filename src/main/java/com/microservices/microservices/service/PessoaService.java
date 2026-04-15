package com.microservices.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.microservices.controller.PessoaController;
import com.microservices.microservices.converter.PessoaConverter;
import com.microservices.microservices.dto.PessoaDto;
import com.microservices.microservices.entities.Pessoa;
import com.microservices.microservices.repository.PessoaRepository;

@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    @Autowired
    PessoaConverter converter;

    public ResponseEntity<String> cadastrar(Pessoa pessoa) {
        repository.save(pessoa);
        return new ResponseEntity<>("Cadastrado com sucesso", HttpStatus.OK);
    }

    public ResponseEntity<List<PessoaDto>> listarTodos() {
        List<Pessoa> pessoas = repository.findAll();
        return new ResponseEntity<>(converter.toListDto(pessoas), HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(int id) {
        repository.deleteById(id);
        return new ResponseEntity<>("A pessoa com o ID " + id + " foi excluido com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(int id, Pessoa pessoaAtualizada) {
        if (repository.existsById(id)) {
            pessoaAtualizada.setId(id);
            repository.save(pessoaAtualizada);
            return new ResponseEntity<>("A pessoa com o ID " + id + " foi alterada com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Pessoa não encontrada.", HttpStatus.NOT_FOUND);
        }
    }
}