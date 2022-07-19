package com.JuhAmil.Lista.de.Vendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {
	
	@Autowired
	private VendaService service;
	
	@GetMapping
	public List<Venda> buscarVendas(){
		return service.buscarVendas();
	}

}
