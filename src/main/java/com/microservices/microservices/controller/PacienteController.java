package com.microservices.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.microservices.dto.PacienteDto;
import com.microservices.microservices.entities.Paciente;
import com.microservices.microservices.service.PacienteService;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService service;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastro(@RequestBody Paciente paciente) {
        return service.cadastrar(paciente);

    }

    @GetMapping("/listarTodos")
    public ResponseEntity<List<PacienteDto>> listarTodos() {
        return service.listarTodos();
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<String> excluir(@PathVariable int id) {
        return service.excluir(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<String> editar(@PathVariable int id, @RequestBody Paciente pacienteAtualizada) {
        return service.editar(id, pacienteAtualizada);
    }

}
