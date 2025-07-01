package org.alura.literalura.literalura.gutendex;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Autor {
	
	@JsonAlias("name")
	private String nome;
	
	@JsonAlias("birth_year")
	private Integer anoNascimento;
	
	@JsonAlias("death_year")
	private Integer anoFalecimento;
}
