package com.vendaFacil.entidades;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.vendaFacil.enuns.FormaPagamento;

public class Venda {
	private Integer id;
	private LocalDateTime dataHora;
	private Cliente cliente;
	private List<VendaItem> itens;
	private BigDecimal valorTotal;
	private BigDecimal desconto;
	private FormaPagamento forma;
	
	public Venda() {
		
	}
	
	
	
	public Venda(Integer id, LocalDateTime dataHora,Cliente cliente,List<VendaItem> itens, BigDecimal valorTotal,
			BigDecimal desconto, FormaPagamento forma) {
		super();
		this.id = id;
		this.dataHora = dataHora;
		this.cliente = cliente;
		this.itens = itens;
		this.valorTotal = valorTotal;
		this.desconto = desconto;
		this.forma = forma;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public LocalDateTime getDataHora() {
	
	return dataHora;
		 
	}

	public void setDataHora(LocalDateTime dataHora) {
		
		this.dataHora =dataHora;
	}

	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<VendaItem> getItens() {
		return itens;
	}
	public void setItens(List<VendaItem> itens) {
		this.itens = itens;
	}
	public BigDecimal getValorTotal() {
		return valorTotal ;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public BigDecimal getDesconto() {
		return desconto;
	}
	public void setDesconto(BigDecimal desconto) {
		this.desconto = desconto;
	}
	public FormaPagamento getForma() {
		return forma;
	}
	public void setForma(FormaPagamento forma) {
		this.forma = forma;
	}
	
	
	public String imprimirVenda(VendaItem item) {
		return "Quant. de tens: "+ item.getQuantidade()+"\n Desconto: "+ getDesconto() +
				"\nTotal: "+getValorTotal();
	}
	

}
