package com.compass.apirest.controller.form;

import com.compass.apirest.modelo.Estado;

public class EstadoForm {
	
	private int id;
	private String nome;
	private String regiao;
	private long populacao;
	private String capital;
	private double area;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
		
		return new Estado(id, nome, regiao, populacao, capital, area);
	}
	
	

}
