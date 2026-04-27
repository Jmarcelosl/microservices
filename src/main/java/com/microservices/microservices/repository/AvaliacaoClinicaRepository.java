package com.microservices.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservices.microservices.entities.AvaliacaoClinica;

@Repository
public interface AvaliacaoClinicaRepository extends JpaRepository<AvaliacaoClinica, Integer> {

}
