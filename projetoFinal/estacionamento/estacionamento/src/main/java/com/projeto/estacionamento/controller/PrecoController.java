package com.projeto.estacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.estacionamento.repository.CarroRepository;
import com.projeto.estacionamento.repository.PrecoRepository;

@RestController
@RequestMapping("/carro/preco")
@CrossOrigin(origins = "http://localhost:3306")
public class PrecoController {
	
	@Autowired
	private CarroRepository carroPrecoRepository;
	
	@Autowired
	private PrecoRepository precoRespository;
	
}

