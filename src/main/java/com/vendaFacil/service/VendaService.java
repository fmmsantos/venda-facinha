package com.vendaFacil.service;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.vendaFacil.entidades.Venda;
import com.vendaFacil.entidades.VendaItem;
import com.vendaFacil.enuns.TipoCliente;



public class VendaService {
	
	public void calcularValorTotalItens(Venda venda){
		
		if (venda.getItens() == null) {
			throw new IllegalStateException("Venda precisa dos itens para calcular o valor total");
		}
		for( VendaItem v : venda.getItens() ) {
			BigDecimal quantidade = new BigDecimal(v.getQuantidade());
			v.setValorTotal(v.getPrecoUnitario().multiply(quantidade).subtract(v.getDesconto()));
			
	System.out.println(v.getValorTotal());
		}
				
	}
	
	public BigDecimal calcularValorTotalVenda(Venda venda) {
		BigDecimal total= new BigDecimal("0");
		
		for(VendaItem v : venda.getItens()) {
			total = total.add(v.getValorTotal());
		}
		venda.setValorTotal(total);
		
		
		return total;
	
	}
	
	public BigDecimal aplicarDescontoTipoCliente(Venda venda) {
	
		
		if (venda.getValorTotal() == null) {
			throw new IllegalStateException("Valor total da venda não informado");
		}
		BigDecimal desconto = BigDecimal.ZERO;
		if( venda.getCliente().getTipoCliente() == TipoCliente.SIMPLES) {
		 desconto= new BigDecimal("0.0").multiply(venda.getValorTotal());
		 }
		else if(venda.getCliente().getTipoCliente() == TipoCliente.ESPECIAL) {	
			desconto= new BigDecimal(0.05).multiply(venda.getValorTotal());	
			}
		else if(venda.getCliente().getTipoCliente() == TipoCliente.VIP) {
			desconto=new BigDecimal("0.075").multiply(venda.getValorTotal());
			
			}
		
		venda.setDesconto(desconto.setScale(2,BigDecimal.ROUND_HALF_EVEN));
		return venda.getDesconto();}
	
	
	
	public void imprimir(Venda venda) {
		VendaService service = new VendaService();
		
		venda.setDataHora(LocalDateTime.now());
		DateTimeFormatter formatter =DateTimeFormatter.ofPattern("dd/MM/yy      HH:mm:ss");
		
	
		System.out.println("----------------------------------------");
		System.out.println("        SISTEMA VENDA FÁCIL  vesão 1.0.0");
		System.out.println("----------------------------------------");
		System.out.println("Numero da venda: " + venda.getId());
		System.out.println("Data: " + venda.getDataHora().format(formatter));
		System.out.println("Cliente: " + venda.getCliente().getNome() + "    CPF: "+venda.getCliente().getCpf());
		System.out.println("-----------------------------------------");
		System.out.println("PRODUTO    " +"  QTD "+ "  PC UNIT. ");
			for(VendaItem v: venda.getItens()) {		
		System.out.println(v.getProduto().getNome()+"    " + v.getQuantidade()+"     "+v.getPrecoUnitario());
		}
		
		System.out.println("-------------------------------------------");
		System.out.println("TOTAL ITENS");	
		service.calcularValorTotalItens(venda);
		System.out.println("-------------------------------------------");
		System.out.println("QUANT. ITENS\n " + venda.getItens().size());
		System.out.println("-------------------------------------------");
		
	
		System.out.println("TOTAL\n" + service.calcularValorTotalVenda(venda) );
	
		System.out.println("DESCONTO\n"+service.aplicarDescontoTipoCliente(venda));
	}
	        
	         
        
}
	
	
			
	
	
		


