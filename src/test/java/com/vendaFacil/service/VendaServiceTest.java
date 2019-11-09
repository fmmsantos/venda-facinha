package com.vendaFacil.service;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.vendaFacil.entidades.Cliente;
import com.vendaFacil.entidades.Venda;
import com.vendaFacil.entidades.VendaItem;
import com.vendaFacil.enuns.TipoCliente;

public class VendaServiceTest {
	
	VendaService vendaService = new VendaService();
	
	@Test
	public void testarCalcularValorTotalItems() {
		Venda venda = new Venda();
		
		VendaItem item1 = new VendaItem();
		VendaItem item2 = new VendaItem();
		
		
		item1.setId(1);
		item1.setPrecoUnitario(new BigDecimal("12.00"));
		item1.setQuantidade(2);
		item1.setDesconto(BigDecimal.ZERO);
		
		item2.setId(2);
		item2.setPrecoUnitario(new BigDecimal("8.30"));
		item2.setQuantidade(4);
		item2.setDesconto(new BigDecimal("2.50"));
		
		venda.setItens(Arrays.asList(item1, item2));
		
		vendaService.calcularValorTotalItens(venda);
		
		Assert.assertEquals(new BigDecimal("24.00"), item1.getValorTotal());
		Assert.assertEquals(new BigDecimal("30.70"), item2.getValorTotal());
		
	}
	
	
	
	@Test
	public void testarcalcularValorTotalVenda() {
		
      Venda venda = new Venda();
		
		VendaItem item1 = new VendaItem();
		VendaItem item2 = new VendaItem();
		VendaItem item3 = new VendaItem();
		
		item1.setId(1);
		item1.setValorTotal(new BigDecimal("24.00"));
		
		
		item2.setId(2);
		item2.setValorTotal(new BigDecimal("32.50"));
	
		
		item3.setId(3);
		item3.setValorTotal(new BigDecimal("10.00"));
		
		
		venda.setItens(Arrays.asList(item1, item2,item3));
		
		BigDecimal totalVenda = vendaService.calcularValorTotalVenda(venda);
		
		Assert.assertEquals(new BigDecimal("66.50"), venda.getValorTotal());
		Assert.assertEquals(new BigDecimal("66.50"), totalVenda);
		
	
	}
	@Test
	public void aplicarDescontoTipoClienteEspecial() {
		
		Venda venda = new Venda();
		VendaItem item1 = new VendaItem();
		VendaItem item2 = new VendaItem();
		VendaItem item3 = new VendaItem();
		
		item1.setId(1);
		item1.setValorTotal(new BigDecimal("10.00"));
		item1.setDesconto(new BigDecimal("0.0"));
		
		item2.setId(2);
		item2.setValorTotal(new BigDecimal("20"));
		item2.setDesconto(new BigDecimal("0.0"));
		
		item3.setId(3);
		item3.setValorTotal(new BigDecimal("10.00"));
		item3.setDesconto(new BigDecimal("0.0"));
		
		Cliente cli1 = new Cliente(1,"fabi",TipoCliente.ESPECIAL,"98765");
		
		venda.setItens(Arrays.asList(item1, item2,item3));
		venda.setValorTotal(new BigDecimal("40.00"));
		
		venda.setCliente(cli1);
		
		BigDecimal desconto = vendaService.aplicarDescontoTipoCliente(venda);

		Assert.assertEquals(new BigDecimal("2.00"), desconto);
		
	
	}
	@Test
	public void aplicarDescontoTipoClienteSimples() {
		
		Venda venda = new Venda();
		VendaItem item1 = new VendaItem();
		VendaItem item2 = new VendaItem();
		VendaItem item3 = new VendaItem();
		
		item1.setId(1);
		item1.setValorTotal(new BigDecimal("30.00"));
		item1.setDesconto(new BigDecimal("3.0"));
		
		item2.setId(2);
		item2.setValorTotal(new BigDecimal("200"));
		item2.setDesconto(new BigDecimal("4.0"));
		
		item3.setId(3);
		item3.setValorTotal(new BigDecimal("100.00"));
		item3.setDesconto(new BigDecimal("2.0"));
		
		Cliente cli1 = new Cliente(1,"fabi",TipoCliente.SIMPLES,"98765");
		
		venda.setItens(Arrays.asList(item1, item2,item3));
		venda.setValorTotal(new BigDecimal("321.00"));
		
		venda.setCliente(cli1);
		
		BigDecimal desconto = vendaService.aplicarDescontoTipoCliente(venda);

		Assert.assertEquals(new BigDecimal("0.00"), desconto);
		
	
	}
	
	@Test
	public void aplicarDescontoTipoClienteVip() {
		
		Venda venda = new Venda();
		VendaItem item1 = new VendaItem();
		VendaItem item2 = new VendaItem();
		VendaItem item3 = new VendaItem();
		
		item1.setId(1);
		item1.setValorTotal(new BigDecimal("30.00"));
		item1.setDesconto(new BigDecimal("3.0"));
		
		item2.setId(2);
		item2.setValorTotal(new BigDecimal("200"));
		item2.setDesconto(new BigDecimal("4.0"));
		
		item3.setId(3);
		item3.setValorTotal(new BigDecimal("100.00"));
		item3.setDesconto(new BigDecimal("2.0"));
		
		Cliente cli1 = new Cliente(1,"fabi",TipoCliente.VIP,"98765");
		
		venda.setItens(Arrays.asList(item1, item2,item3));
		venda.setValorTotal(new BigDecimal("321.00"));
		
		venda.setCliente(cli1);
		
		BigDecimal desconto = vendaService.aplicarDescontoTipoCliente(venda);

		Assert.assertEquals(new BigDecimal("24.08"), desconto);
		
	
	}
	
}
