package com.projeto.estacionamento.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "carro")
public class Carro {
//ATRIBUTOS
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "marca")
	private String marca;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "placa")
	private String placa;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy HH:mm")
	private LocalDateTime entrada = LocalDateTime.now();
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yy HH:mm")
	private LocalDateTime saida;
	
	@Column(name = "valor")
	private int valor;

//CONSTRUTORES
	public Carro() {}
	
	public Carro(String marca, String modelo, String placa) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
	}

//GETTERS & SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public LocalDateTime getEntrada() {
		return entrada;
	}

	public void setEntrada(LocalDateTime entrada) {
		this.entrada = entrada;
	}

	public LocalDateTime getSaida() {
		return saida;
	}

	public void setSaida(LocalDateTime saida) {
		this.saida = saida;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int calcularValor() {
		double permanencia;
		this.saida = LocalDateTime.now();
		permanencia = ChronoUnit.HOURS.between(this.entrada, this.saida);
		
		if(permanencia <= 1) {
			valor = 5;
		} else {
			double qtHoras = permanencia - 1;
			valor = (int) ((qtHoras * 2) + 5);
		}
		
		return getValor();
	}
	
	
}
