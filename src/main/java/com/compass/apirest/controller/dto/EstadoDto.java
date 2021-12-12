package com.compass.apirest.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.compass.apirest.modelo.Estado;

public class EstadoDto {

	private int id;
	private String nome;
	private String regiao;
	private long populacao;
	private String capital;
	private double area;
	
	public EstadoDto() {
		
	}

	public EstadoDto(Estado estado) {
		this.id = estado.getId();
		this.nome = estado.getNome();
		this.regiao = estado.getRegiao();
		this.populacao = estado.getPopulacao();
		this.capital = estado.getCapital();
		this.area = estado.getArea();
	}
	
	public static List<EstadoDto> converter(List<Estado> estados) {
		return estados.stream().map(EstadoDto::new).collect(Collectors.toList());
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getRegiao() {
		return regiao;
	}

	public long getPopulacao() {
		return populacao;
	}

	public String getCapital() {
		return capital;
	}

	public double getArea() {
		return area;
	}

}
