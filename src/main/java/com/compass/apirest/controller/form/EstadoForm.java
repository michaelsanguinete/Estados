package com.compass.apirest.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

import com.compass.apirest.modelo.Estado;
import com.compass.apirest.repository.EstadoRepository;

public class EstadoForm {
	
	@NotNull @NotEmpty
	private String nome;
	@NotNull @NotEmpty
	private String regiao;
	@Range(min = 0)
	private long populacao;
	@NotNull @NotEmpty
	private String capital;
	@Range(min = 0)
	private double area;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public long getPopulacao() {
		return populacao;
	}
	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public Estado converter() {
		
		return new Estado(nome, regiao, populacao, capital, area);
	}
	public Estado atualizar(int id, EstadoRepository estadoRepository) {
		
		Estado estado = estadoRepository.getById(id);
		estado.setArea(this.area);
		estado.setCapital(this.capital);
		estado.setNome(this.nome);
		estado.setPopulacao(this.populacao);
		estado.setRegiao(this.regiao);
		
		return estado;
	}
	
	

}
