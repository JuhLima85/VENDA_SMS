package com.JuhAmil.Lista.de.Vendas.services;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.exception.SmsException;
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

	public String enviarSms(Venda venda) {
		try {
			Locale.setDefault(new Locale("en", "US"));

			String data = venda.getData().getMonthValue() + "/" + venda.getData().getYear();
			String msg = null;				

			if(venda.getTotal() <= 200) {
				msg = venda.getVendedor() + ", em " + data + " você vendeu um total de R$ "
						+ venda.getTotal() + ". Infelizmente você não alcançou a meta esperada, não desanime, pois ainda há tempo para aprimorar seus resultados.";
			}else if(venda.getTotal() <= 1000) {
				msg = venda.getVendedor() + ", em " + data + " você vendeu um total de R$ "
						+ venda.getTotal() + ". Parabéns, você alcançou a meta esperada!";
			}else {
				msg = venda.getVendedor() + ", em " + data + " você vendeu um total de R$ "
						+ venda.getTotal() + ". Parabéns pelo seu desempelho! Você superou a meta esperada.";
			}			

			Twilio.init(twilioSid, twilioKey);			
			PhoneNumber to = new PhoneNumber(twilioPhoneTo);
			PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
			Message.creator(to, from, msg).create();			
			
			return msg;			
		} catch (Exception e) {
			throw new SmsException("Erro ao enviar a mensagem SMS: " + e.getMessage());
		}

	}
}
