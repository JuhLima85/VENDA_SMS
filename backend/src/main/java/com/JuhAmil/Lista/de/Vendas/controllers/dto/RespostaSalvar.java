package com.JuhAmil.Lista.de.Vendas.controllers.dto;

import java.util.List;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;

public class RespostaSalvar {	
	
	    private List<Venda> vendas;
	    private String mensagem;
	    	   
	    public RespostaSalvar() {
			super();
			
		}

		public RespostaSalvar(List<Venda> vendas, String mensagem) {
	        this.vendas = vendas;
	        this.mensagem = mensagem;
	    }
	    
	    public List<Venda> getVendas() {
	        return vendas;
	    }

	    public void setVendas(List<Venda> vendas) {
	        this.vendas = vendas;
	    }

	    public String getMensagem() {
	        return mensagem;
	    }

	    public void setMensagem(String mensagem) {
	        this.mensagem = mensagem;
	    }
	}