package com.projeto.estacionamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.estacionamento.model.Preco;

public interface PrecoRepository extends JpaRepository<Preco, Long> {

}
