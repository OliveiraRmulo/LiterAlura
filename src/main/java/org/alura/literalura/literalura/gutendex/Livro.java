package org.alura.literalura.literalura.gutendex;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Livro {

	@JsonAlias("title")
	private String titulo;
	
	@JsonAlias("authors")
	private List<Autor> autores;
	
	@JsonAlias("languages")
	private List<String> linguagens;
	
	@JsonAlias("download_count")
	private Integer dowload;
}
