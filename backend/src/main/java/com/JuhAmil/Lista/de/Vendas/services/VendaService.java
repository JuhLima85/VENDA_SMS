package com.JuhAmil.Lista.de.Vendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	public List<Venda> buscarVendas() {
		return repository.findAll();
	}

}
