package org.alura.literalura.literalura.service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.alura.literalura.literalura.gutendex.ResultadoBusca;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GutendexService {

	private final HttpClient client = HttpClient.newHttpClient();
	private final ObjectMapper mapper = new ObjectMapper();

	public ResultadoBusca buscarLivros(String termo) {
		try {
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create("https://gutendex.com/books/?search=" + termo)).build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			return mapper.readValue(response.body(), ResultadoBusca.class);

		} catch (Exception e) {
			System.out.println("Erro na busca: " + e.getMessage());
			return null;
		}
	}
}
