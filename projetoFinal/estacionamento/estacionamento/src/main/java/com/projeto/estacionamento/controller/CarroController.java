package com.projeto.estacionamento.controller;

import java.time.LocalDateTime;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.estacionamento.exceptions.ResourceNotFoundException;
import com.projeto.estacionamento.model.Carro;
import com.projeto.estacionamento.repository.CarroRepository;
import com.projeto.estacionamento.service.RelatorioDto;

@RestController
@RequestMapping("/estacionados")
@CrossOrigin(origins = "http://localhost:3306")
public class CarroController {
	
	@Autowired
	private CarroRepository estacionadosRepository;
	
	@Autowired
	private RelatorioDto relatorioDto;
	
	//DEVOLVE A LISTA DE TODOS OS CARROS ESTACIONADOS
	@GetMapping("/todosEstacionados")
	public List<Carro> devolveEstacionados() {
		return estacionadosRepository.findAll();
	}
	
	//GERA REGISTRO NO BANCO DE DADOS NA RELAÇÃO DE CARROS ESTACIONADOS
	@PostMapping("/todosEstacionados")
	public Carro geraEstacionado(@RequestBody Carro estacionado) {
		return estacionadosRepository.save(estacionado);
	}
	
	//DEVOLVE O REGISTRO DA MOVIMENTACAO "ESTACIONADOS" PELO ID	
	public ResponseEntity<Carro> getEstacionadoById(@PathVariable Long id) {
		Carro estacionado = estacionadosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Registro inexistente"));
		return ResponseEntity.ok(estacionado);
	}
	
	//APAGA REGISTRO DO CARRO ESTACIONADO
	@DeleteMapping("/todosEstacionados")
	public ResponseEntity<Map<String, Boolean>> deletaEstacionado(@PathVariable Long id) {
		Carro estacionado = estacionadosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Registro inexistente"));
		
		estacionadosRepository.delete(estacionado);
		Map<String, Boolean> response = new HashMap<>();
		response.put("REGISTRO APAGADO", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
	//GERA O REGISTRO DE SAÍDA
	public ResponseEntity<Carro> geraSaida(@PathVariable Long id, @RequestBody Carro carro) {
		Carro estacionado = estacionadosRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Registro Inexistente"));
		
		estacionado.setEntrada(LocalDateTime.now());
		estacionado.setValor(carro.calcularValor());
		
		Carro updateEstacionamento = estacionadosRepository.save(carro);
		return ResponseEntity.ok(updateEstacionamento);
	}
	
	//RETORNA OS REGISTROS DE SAÍDAS
	@GetMapping("/todosCarros/saidas")
	public List<Carro> retornaSaidasCarros() {
		List<Carro> relatorio = relatorioDto.gerarRelatorio();
		return relatorio;
	}	
}
