package com.JuhAmil.Lista.de.Vendas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.services.SmsService;
import com.JuhAmil.Lista.de.Vendas.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaController {

	@Autowired
	private VendaService service;

	@Autowired
	private SmsService smsService;

	@GetMapping
	public Page<Venda> buscarVendas(@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable) {
		return service.buscarVendas(minDate, maxDate, pageable);
	}

	@GetMapping("/{id}/notificacao")
	public void notificar(@PathVariable Long id) {
		smsService.enviarSms(id);
	}

}
