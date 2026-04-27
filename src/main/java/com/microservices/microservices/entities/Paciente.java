package com.microservices.microservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cpf;
    private Integer idade;
    private String diagnostico;
    private Integer nivelDePrioridade;

    public Paciente() {
    }

    public Paciente(Integer id, String nome, String cpf, Integer idade, String diagnostico, Integer nivelDePrioridade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.diagnostico = diagnostico;
        this.nivelDePrioridade = nivelDePrioridade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Integer getNivelDePrioridade() {
        return nivelDePrioridade;
    }

    public void setNivelDePrioridade(Integer nivelDePrioridade) {
        this.nivelDePrioridade = nivelDePrioridade;
    }

}
