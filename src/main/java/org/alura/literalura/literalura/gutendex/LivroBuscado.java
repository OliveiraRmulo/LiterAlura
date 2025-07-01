package org.alura.literalura.literalura.gutendex;

import lombok.Data;

@Data
public class LivroBuscado {

	private String titulo;
	private String autor;
	private String idioma;
	private int downloads;

	public LivroBuscado(String titulo, String autor, String idioma, int downloads) {
		this.titulo = titulo;
		this.autor = autor;
		this.idioma = idioma;
		this.downloads = downloads;
	}
}
