package com.compass.apirest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public List<EstadoDto> listar(String regiao) {
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
	
	public void cadastrar (@RequestBody EstadoForm form) {
		
		Estado estado = form.converter();
		estadoRepository.save(estado);
		
	}
	
	

}
