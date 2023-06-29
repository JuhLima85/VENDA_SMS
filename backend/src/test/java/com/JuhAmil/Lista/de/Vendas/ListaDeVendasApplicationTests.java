package com.JuhAmil.Lista.de.Vendas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;

import com.JuhAmil.Lista.de.Vendas.controllers.RespostaSalvar;
import com.JuhAmil.Lista.de.Vendas.entidades.Venda;
import com.JuhAmil.Lista.de.Vendas.repositories.VendaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:test.properties")
class ListaDeVendasApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private VendaRepository vendaRepository;

	private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());

	@Autowired
	private TestRestTemplate restTemplate;

	final Venda venda = new Venda("Fulano da S ilva", 5, 100.0, "2023-06-28");

	@Test
	void CadastrarEListarVendas() throws Exception {
		vendaRepository.deleteAll();
		salvarVenda(venda);
	    consultarVenda(venda.getId());
		vendaRepository.deleteAll();
		var listaVendas = listarVendas();
		assertEquals(0, listaVendas.size());
	}

	@ParameterizedTest
	@NullAndEmptySource
	void dadosInvalidos(String conteudo) throws Exception {
		vendaRepository.deleteAll();
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpRequest = new HttpEntity<>(objectMapper.writeValueAsString(conteudo), httpHeaders);
		var responseCode = restTemplate.postForEntity(getURLDoServico(), httpRequest, Venda.class).getStatusCode();
		assertEquals(HttpStatus.BAD_REQUEST, responseCode);
	}
	
	private void salvarVenda(final Venda venda) throws Exception {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> httpRequest = new HttpEntity<>(objectMapper.writeValueAsString(venda), httpHeaders);
		ResponseEntity<RespostaSalvar> response = restTemplate.exchange(getURLDoServico(), HttpMethod.POST, httpRequest,
				new ParameterizedTypeReference<RespostaSalvar>() {
				});
		assertEquals(HttpStatus.CREATED, response.getStatusCode());

	}

	private Venda consultarVenda(long id) {
		return restTemplate.getForObject(getURLDoServico() + id, Venda.class);

	}

	private List<Venda> listarVendas() {
		return restTemplate.exchange(getURLDoServico(), HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), List.class)
				.getBody();
	}

	private String getURLDoServico() {
		return "http://localhost:" + port + "/vendas/";
	}

}
