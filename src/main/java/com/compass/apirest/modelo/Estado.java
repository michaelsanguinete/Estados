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
	// @Enumerated(EnumType.STRING)
	private String regiao;
	private long populacao;
	private String capital;
	private double area;

	public Estado() {

	}

	public Estado(int id, String nome, String regiao, long populacao, String capital, double area) {
		this.id = id;
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
