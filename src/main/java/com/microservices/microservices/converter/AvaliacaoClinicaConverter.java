package com.microservices.microservices.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.microservices.dto.AvaliacaoClinicaDto;
import com.microservices.microservices.entities.AvaliacaoClinica;

@Component
public class AvaliacaoClinicaConverter {

    public AvaliacaoClinicaDto toDto(AvaliacaoClinica avaliacaoclinica) {
        return new AvaliacaoClinicaDto(avaliacaoclinica.getId(), avaliacaoclinica.getIdPaciente(),
                avaliacaoclinica.getObservacoes(), avaliacaoclinica.getDataAvaliacao());
    }

    public List<AvaliacaoClinicaDto> toListDto(List<AvaliacaoClinica> avaliacaoclinicas) {
        return avaliacaoclinicas.stream().map(avaliacaoclinica -> toDto(avaliacaoclinica)).toList();
    }

}
