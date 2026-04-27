package com.microservices.microservices.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AvaliacaoClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idPaciente;
    private String observacoes;
    private String dataAvaliacao;

    public AvaliacaoClinica() {
    }

    public AvaliacaoClinica(int id, int idPaciente, String observacoes, String dataAvaliacao) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.observacoes = observacoes;
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(String dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

}
