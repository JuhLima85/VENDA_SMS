package com.JuhAmil.Lista.de.Vendas.controllers;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.JuhAmil.Lista.de.Vendas.controllers.dto.RespostaSalvar;
import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.exception.ApiResponse;
import com.JuhAmil.Lista.de.Vendas.exception.VendaException;
import com.JuhAmil.Lista.de.Vendas.services.VendaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/vendas")
@Api(value = "API REST Vendas")
@CrossOrigin(origins = "*")
public class VendaController {

	@Autowired
	private VendaService service;
	
	@PostMapping
	@ApiOperation(value = "Calcula o total, salva a venda e envia sms personalizada")
	public ResponseEntity<?> salvar(@RequestBody Venda venda) {
	    try {
	        Map<String, Object> resultado = service.salvar(venda);
	        Venda vendaComTotal = (Venda) resultado.get("venda");
	        String mensagem = (String) resultado.get("msg");
	        
	        RespostaSalvar resposta = new RespostaSalvar();
	        resposta.setVendas(Collections.singletonList(vendaComTotal));
	        resposta.setMensagem(mensagem);
	        
	        return ResponseEntity.status(HttpStatus.CREATED).body(resposta);
	    } catch (VendaException e) {
	        ApiResponse errorResponse = new ApiResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),
	                "Erro ao salvar a venda.", e.getMessage());
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}
	
	@GetMapping
	@ApiOperation(value = "Retorna uma lista de vendas")
	public List<Venda> buscarVendas(@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable) {
		Page<Venda> vendasPage = service.buscarVendas(minDate, maxDate, pageable);
		List<Venda> vendasList = vendasPage.getContent();
		return vendasList;
	}

}
