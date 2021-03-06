package com.projeto.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.estacionamento.model.Carro;

@Repository
public interface RelatorioDtoRepository extends JpaRepository<Carro, Long> {
	
}
