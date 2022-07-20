package com.JuhAmil.Lista.de.Vendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.repositories.VendaRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private VendaRepository vendaRepository;

	public void enviarSms(Long vendaId) {
		
	Venda venda = vendaRepository.findById(vendaId).get();
	
	String data = venda.getData().getMonthValue() + "/" + venda.getData().getYear();
	
	
	String msg = "O vendedor(a) " + venda.getVendedor() + " foi destaque em " + data
			+ " com o total de R$ " + venda.getTotal();

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
