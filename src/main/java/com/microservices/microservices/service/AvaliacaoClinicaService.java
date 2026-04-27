package com.microservices.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.microservices.converter.AvaliacaoClinicaConverter;
import com.microservices.microservices.dto.AvaliacaoClinicaDto;
import com.microservices.microservices.entities.AvaliacaoClinica;
import com.microservices.microservices.repository.AvaliacaoClinicaRepository;

@Service
public class AvaliacaoClinicaService {

    @Autowired
    AvaliacaoClinicaRepository repository;

    @Autowired
    AvaliacaoClinicaConverter converter;

    public ResponseEntity<String> cadastrar(AvaliacaoClinica avaliacaoclinica) {
        repository.save(avaliacaoclinica);
        return new ResponseEntity<>("Registrado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<List<AvaliacaoClinicaDto>> listarTodos() {
        List<AvaliacaoClinica> avaliacaoclinicas = repository.findAll();
        return new ResponseEntity<>(converter.toListDto(avaliacaoclinicas), HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(int id) {
        repository.deleteById(id);
        return new ResponseEntity<>("O registro com o ID " + id + " foi excluido com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(int id, AvaliacaoClinica avaliacaoclinicaAtualizada) {
        if (repository.existsById(id)) {
            avaliacaoclinicaAtualizada.setId(id);
            repository.save(avaliacaoclinicaAtualizada);
            return new ResponseEntity<>("O registro com o ID " + id + " foi alterado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Registro não encontrada.", HttpStatus.NOT_FOUND);
        }
    }

}
