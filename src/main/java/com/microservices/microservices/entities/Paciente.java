package com.microservices.microservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    private int idade;
    private String diagnostico;
    private int nivelDePrioridade;

    public Paciente() {
    }

    public Paciente(int id, String nome, String cpf, int idade, String diagnostico, int nivelDePrioridade) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.diagnostico = diagnostico;
        this.nivelDePrioridade = nivelDePrioridade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public int getNivelDePrioridade() {
        return nivelDePrioridade;
    }

    public void setNivelDePrioridade(int nivelDePrioridade) {
        this.nivelDePrioridade = nivelDePrioridade;
    }

}
