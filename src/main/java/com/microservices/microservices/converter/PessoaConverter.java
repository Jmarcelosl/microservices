package com.microservices.microservices.converter;

import java.util.List;

import org.springframework.stereotype.Component;

import com.microservices.microservices.dto.PessoaDto;
import com.microservices.microservices.entities.Pessoa;

@Component
public class PessoaConverter {

    public PessoaDto toDto(Pessoa pessoa) {
        return new PessoaDto(pessoa.getNome(), pessoa.getLogin());
    }

    public List<PessoaDto> toListDto(List<Pessoa> pessoas) {
        return pessoas.stream().map(pessoa -> toDto(pessoa)).toList();
    }
}
