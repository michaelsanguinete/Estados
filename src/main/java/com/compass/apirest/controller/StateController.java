package com.compass.apirest.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.apirest.controller.dto.EstadoDto;
import com.compass.apirest.controller.form.EstadoForm;
import com.compass.apirest.modelo.Estado;
import com.compass.apirest.modelo.Regioes;
import com.compass.apirest.repository.EstadoRepository;

@RestController
@RequestMapping("/api/states")
public class StateController {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<EstadoDto> listarTodos(@RequestParam(required = false) String filtro,
			@RequestParam(required = false) Regioes regiao) {

		List<Estado> estados;

		if (regiao == null) {
			estados = estadoRepository.findAll();

		} else {
			estados = estadoRepository.findByRegiao(regiao);

		}
		if (filtro != null) {
			if (filtro.equalsIgnoreCase("Populacao")) {
				estados = estadoRepository.findAll(Sort.by("populacao").descending());
			}

			else if (filtro.equalsIgnoreCase("Area")) {
				estados = estadoRepository.findAll(Sort.by("area").descending());

			}
		}
		return EstadoDto.converter(estados);

	}

	@PostMapping
	@Transactional
	public ResponseEntity<EstadoDto> cadastrar(@RequestBody @Valid EstadoForm form, UriComponentsBuilder uriBuilder) {

		Estado estado = form.converter();
		estadoRepository.save(estado);

		URI uri = uriBuilder.path("/{id}").buildAndExpand(estado.getId()).toUri();
		return ResponseEntity.created(uri).body(new EstadoDto(estado));

	}

	@GetMapping("/{id}")
	public ResponseEntity<EstadoDto> listarIndividual(@PathVariable int id) {

		Optional<Estado> estado = estadoRepository.findById(id);
		if (estado.isPresent())
			return ResponseEntity.ok(new EstadoDto(estado.get()));

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<EstadoDto> atualizar(@PathVariable int id, @RequestBody @Valid EstadoForm form) {

		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			Estado estado = form.atualizar(id, estadoRepository);
			return ResponseEntity.ok(new EstadoDto(estado));
		}

		return ResponseEntity.notFound().build();

	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletar(@PathVariable int id) {

		Optional<Estado> optional = estadoRepository.findById(id);
		if (optional.isPresent()) {
			estadoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();

	}

}
