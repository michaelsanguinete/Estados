package com.compass.apirest.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.apirest.controller.dto.EstadoDto;
import com.compass.apirest.controller.form.EstadoForm;
import com.compass.apirest.modelo.Estado;
import com.compass.apirest.repository.EstadoRepository;


@RestController
@RequestMapping("/api/states")
public class StateController {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<EstadoDto> listarTodos(String regiao) {
		if (regiao ==null) {
			List<Estado> estados = estadoRepository.findAll();
			return EstadoDto.converter(estados);
		}
		else {
			List<Estado> estados = estadoRepository.findByRegiao(regiao);
			return EstadoDto.converter(estados);
		}
		
	}
	
	@PostMapping
	
	public ResponseEntity<EstadoDto> cadastrar (@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriBuilder) {
		
		Estado estado = form.converter();
		estadoRepository.save(estado);
	
		URI uri = uriBuilder.path("/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDto(estado));
		
	}
	
	
	@GetMapping("/{id}")
	public EstadoDto listarIndividual(@PathVariable int id) {
		
		Estado estado = estadoRepository.getById(id);
		
		return new EstadoDto(estado);
	}
	
	

}
