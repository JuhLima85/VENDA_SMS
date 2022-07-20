package com.JuhAmil.Lista.de.Vendas.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	public Page<Venda> buscarVendas(String minDate, String maxDate, Pageable pageable) {
		
		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
		
		LocalDate mim =  minDate.equals("") ? hoje.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? hoje : LocalDate.parse(maxDate);
		
		return repository.findVendas(mim, max, pageable);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
