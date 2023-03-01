package com.alura.externalservices;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.alura.domain.ConversaoIndisponivelException;
import com.alura.domain.CotacaoService;
import com.alura.domain.Moeda;

public class EconomiaAwesomeAPICotacaoService implements CotacaoService {

	private final String API_URL = "https://economia.awesomeapi.com.br/last/";
	private HttpClient httpClient;
	private URI uri;
	private HttpRequest request;
	private HttpResponse<String> response;

	@Override
	public double getCotacao(Moeda moedaAtual, Moeda moedaAlvo) throws ConversaoIndisponivelException {
		configureHttpClient();
		configureURI(moedaAtual, moedaAlvo);
		configureRequest();
		doRequest();

		return findCotacaoNaResposta();
	}

	private void configureHttpClient() {
		httpClient = HttpClient.newHttpClient();
	}

	private void configureURI(Moeda moedaAtual, Moeda moedaAlvo) {
		uri = URI.create(API_URL + moedaAtual + "-" + moedaAlvo);
	}

	private void configureRequest() {
		request = HttpRequest.newBuilder().uri(uri).GET().build();
	}

	private void doRequest() throws ConversaoIndisponivelException {
		try {
			response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException | InterruptedException e) {
			throw new ConversaoIndisponivelException();
		}
	}

	private double findCotacaoNaResposta() {
		// O body da resposta é interpretado como String, dessa forma é usado
		// regex para encontrar o valor da cotação.

		String responseBody = response.body();

		Pattern pattern = Pattern.compile("\"low\":\"(\\d+(\\.\\d+)?)\"");
		Matcher matcher = pattern.matcher(responseBody);

		matcher.find();
		String numeroComoString = matcher.group(1);

		return Double.parseDouble(numeroComoString);
	}

}
