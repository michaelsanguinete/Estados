package com.compass.apirest.modelo;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ESTADOS")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	@Enumerated(EnumType.STRING)
	private Regioes regiao;
	private long populacao;
	private String capital;
	private double area;

	public Estado() {

	}

	public Estado(String nome, Regioes regiao, long populacao, String capital, double area) {
		this.nome = nome;
		this.regiao = regiao;
		this.populacao = populacao;
		this.capital = capital;
		this.area = area;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Regioes getRegiao() {
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

	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRegiao(Regioes regiao) {
		this.regiao = regiao;
	}

	public void setPopulacao(long populacao) {
		this.populacao = populacao;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	public void setArea(double area) {
		this.area = area;
	}

	
	
}
