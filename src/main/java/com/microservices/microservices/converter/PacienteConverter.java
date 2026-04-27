package com.microservices.microservices.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.microservices.dto.PacienteDto;
import com.microservices.microservices.entities.Paciente;

@Component
public class PacienteConverter {

    public PacienteDto toDto(Paciente paciente) {
        return new PacienteDto(paciente.getId(), paciente.getNome(), paciente.getCpf(),
                paciente.getIdade(), paciente.getDiagnostico(), paciente.getNivelDePrioridade());
    }

    public List<PacienteDto> toListDto(List<Paciente> pacientes) {
        return pacientes.stream().map(paciente -> toDto(paciente)).toList();
    }

}
