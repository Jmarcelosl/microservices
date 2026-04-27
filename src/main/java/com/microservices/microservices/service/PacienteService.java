package com.microservices.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservices.microservices.converter.PacienteConverter;
import com.microservices.microservices.dto.PacienteDto;
import com.microservices.microservices.entities.Paciente;
import com.microservices.microservices.repository.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    @Autowired
    PacienteConverter converter;

    public ResponseEntity<String> cadastrar(Paciente paciente) {
        repository.save(paciente);
        return new ResponseEntity<>("Registrado com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<List<PacienteDto>> listarTodos() {
        List<Paciente> pacientes = repository.findAll();
        return new ResponseEntity<>(converter.toListDto(pacientes), HttpStatus.OK);
    }

    public ResponseEntity<String> excluir(int id) {
        repository.deleteById(id);
        return new ResponseEntity<>("O registro com o ID " + id + " foi excluido com sucesso!", HttpStatus.OK);
    }

    public ResponseEntity<String> editar(int id, Paciente pacienteAtualizada) {
        if (repository.existsById(id)) {
            pacienteAtualizada.setId(id);
            repository.save(pacienteAtualizada);
            return new ResponseEntity<>("O registro com o ID " + id + " foi alterado com sucesso!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Registro não encontrada.", HttpStatus.NOT_FOUND);
        }
    }

}
