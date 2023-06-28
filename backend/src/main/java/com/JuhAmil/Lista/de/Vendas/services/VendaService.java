package com.JuhAmil.Lista.de.Vendas.services;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.exception.VendaException;
import com.JuhAmil.Lista.de.Vendas.repositories.VendaRepository;

@Service
public class VendaService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private VendaRepository repository;

	@Autowired
	private SmsService smsService;	

	public Map<String, Object> salvar(Venda venda) {
	    try {
	        var resultado = venda.getQtdVenda() * venda.getPrecoUnitario();
	        venda.setTotal(resultado);
	        Venda vendaSalva = repository.save(venda);
	        String msg = null;

	        if (vendaSalva != null) {
	            msg = smsService.enviarSms(venda);
	        } else {
	            throw new VendaException("Erro ao salvar a venda");
	        }

	        Map<String, Object> resultadoFinal = new HashMap<>();
	        resultadoFinal.put("venda", vendaSalva);
	        resultadoFinal.put("msg", msg);

	        return resultadoFinal;

	    } catch (VendaException e) {
	        throw e;
	    } catch (Exception e) {
	        throw new RuntimeException("Erro ao salvar a venda: " + e.getMessage());
	    }
	}


//	public Venda salvar(Venda venda) {
//		try {
//			var resultado = venda.getQtdVenda() * venda.getPrecoUnitario();
//			venda.setTotal(resultado);
//			Venda vendaSalva = repository.save(venda);
//			String msg = null;
//			
//			if (vendaSalva != null) {
//				msg = smsService.enviarSms(venda);
//			}else {
//				throw new VendaException("Erro ao salvar a venda");
//			}
//
//			return vendaSalva;
//
//		}catch(VendaException e) {
//			throw e;
//		} 		
//		catch (Exception e) {
//			throw new RuntimeException("Erro ao salvar a venda: " + e.getMessage());
//		}
//	}

	public Page<Venda> buscarVendas(String minDate, String maxDate, Pageable pageable) {

		LocalDate hoje = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

		LocalDate mim = minDate.equals("") ? hoje.minusDays(365) : LocalDate.parse(minDate);
		LocalDate max = maxDate.equals("") ? hoje : LocalDate.parse(maxDate);

		return repository.findVendas(mim, max, pageable);
	}

}
