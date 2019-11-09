package com.vendaFacil.entidades;

import java.math.BigDecimal;

public class VendaItem  {
	private Integer id;
	private Venda venda;
	private BigDecimal precoUnitario;
	private Produto produto;
	private Integer quantidade;
	private BigDecimal desconto;
	private BigDecimal valorTotal;
	
	
	
	
	
	public VendaItem() {
		super();
	}
	public VendaItem(Integer id,  BigDecimal precoUnitario, Produto produto, Integer quantidade,
			BigDecimal desconto) {
		super();
		this.id = id;
	
		this.precoUnitario = precoUnitario;
		this.produto = produto;
		this.quantidade = quantidade;
		this.desconto = desconto;
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Venda getVenda() {
		return venda;
	}
	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	public BigDecimal getPrecoUnitario() {
		return precoUnitario;
	}
	public void setPrecoUnitario(BigDecimal precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public Produto getProduto() {
		return produto;
	}
	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	public Integer getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
		
	}
	public String imprimir() {
		return "Produto: " + getProduto()+ "\nQuantidade: "+getQuantidade() +
				"\nPreço Unitário: "+ getPrecoUnitario() + "\n Tota: " +getValorTotal();
	}
}