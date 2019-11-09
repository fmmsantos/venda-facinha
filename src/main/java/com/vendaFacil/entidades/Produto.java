package com.vendaFacil.entidades;

import java.math.BigDecimal;

public class Produto {
	private Integer id;
	private String nome;
	private BigDecimal precoUnitario;
	
	
	public Produto() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public Produto(Integer id, String nome, BigDecimal precoUnitario) {
		super();
		this.id = id;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	
	

}
