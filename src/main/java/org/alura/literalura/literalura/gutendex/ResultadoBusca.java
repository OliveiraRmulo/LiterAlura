package org.alura.literalura.literalura.gutendex;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResultadoBusca {
	
	private Integer quantidade;
	private List<Livro> livros;
}
