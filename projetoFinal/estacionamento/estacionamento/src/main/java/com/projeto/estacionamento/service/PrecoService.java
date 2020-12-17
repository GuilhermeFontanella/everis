package com.projeto.estacionamento.service;

import java.util.ArrayList;
import java.util.List;

import com.projeto.estacionamento.model.Carro;

public class PrecoService {
	private List<Carro> valor = new ArrayList<> ();
	
	public List<Carro> getValor() {
		for (Carro carro : valor) {
			carro.getValor();
		}
		return valor;
	}
	
	public void setValor(List<Carro> valor) {
		this.valor = valor;
	}
	
	public int somaValor(int soma) {
		return soma;
	}
}
