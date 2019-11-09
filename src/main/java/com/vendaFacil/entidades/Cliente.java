package com.vendaFacil.entidades;

import com.vendaFacil.enuns.TipoCliente;

public class Cliente {
	private Integer id;
	private String nome;
	private TipoCliente tipoCliente;
	private String cpf;
	
	
	
	public Cliente(Integer id, String nome, TipoCliente tipoCliente, String cpf) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipoCliente = tipoCliente;
		this.cpf = cpf;
	
	}
	
	
	public Cliente() {
		super();
	}




	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Integer getId() {
		return id;
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
	public TipoCliente getTipoCliente() {
		return tipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		this.tipoCliente = tipoCliente;
	}
	
}
