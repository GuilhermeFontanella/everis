package com.projeto.estacionamento.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.estacionamento.model.Carro;
import com.projeto.estacionamento.repository.CarroRepository;

@Service 
public class RelatorioDto {
	@Autowired
	CarroRepository carroRepository;
	
	private Long id;
	private String marca;
	private String modelo; 
	private String placa;
	private int valor;
	private LocalDateTime entrada;
	private LocalDateTime saida;
	
	public Long getId() {
		return id;
	}

	public String getMarca() {
		return marca;
	}

	public String getModelo() {
		return modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public int getValor() {
		return valor;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}
	
	public List<Carro> gerarRelatorio() {
		List<Carro> relatorio = new ArrayList<>();
		List<Carro> relacao = carroRepository.findAll();
		
		for(Carro carro: relacao) {
			if(carro.getValor() > 0) {
				Carro salvar = carroRepository.save(carro);
				relatorio.add(salvar);
			}
		} 
		return relatorio;			
	}
}

