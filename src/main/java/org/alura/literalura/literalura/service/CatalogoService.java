package org.alura.literalura.literalura.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.alura.literalura.literalura.gutendex.Autor;
import org.alura.literalura.literalura.gutendex.AutorRegistrado;
import org.alura.literalura.literalura.gutendex.Livro;
import org.alura.literalura.literalura.gutendex.LivroBuscado;

public class CatalogoService {

	private final List<LivroBuscado> livrosBuscados = new ArrayList<>();
	private final List<AutorRegistrado> autoresRegistrados = new ArrayList<>();

	public void adicionarLivro(Livro livro) {
		String titulo = livro.getTitulo();
		String autor = livro.getAutores().isEmpty() ? "Autor desconhecido" : livro.getAutores().get(0).getNome();
		String idioma = livro.getLinguagens().isEmpty() ? "n/a" : livro.getLinguagens().get(0);
		int downloads = livro.getDowload() != null ? livro.getDowload() : 0;

		LivroBuscado livroBuscado = new LivroBuscado(titulo, autor, idioma, downloads);
		
		if (!livro.getAutores().isEmpty()) {
		    Autor autores = livro.getAutores().get(0);
		    registrarAutor(autores);
		}
		
		livrosBuscados.add(livroBuscado);
		System.out.println("✅ Livro adicionado ao catálogo!");
	}
	
	public void registrarAutor(Autor autor) {
	    String nome = autor.getNome();
	    Integer nascimento = autor.getAnoNascimento();
	    Integer falecimento = autor.getAnoFalecimento();

	    AutorRegistrado autorRegistrado = new AutorRegistrado(nome, nascimento, falecimento);

	    boolean jaRegistrado = autoresRegistrados.stream()
	        .anyMatch(a -> a.getNome().equalsIgnoreCase(nome));
	    if (!jaRegistrado) {
	        autoresRegistrados.add(autorRegistrado);
	    }
	}

	public List<AutorRegistrado> listarAutores() {
	    return autoresRegistrados;
	}

	public List<AutorRegistrado> buscarAutoresVivosEm(int ano) {
	    return autoresRegistrados.stream()
	        .filter(a -> a.estavaVivoEm(ano))
	        .collect(Collectors.toList());
	}

	public List<LivroBuscado> listarTodos() {
		return livrosBuscados;
	}

	public List<LivroBuscado> buscarPorIdioma(String idioma) {
		return livrosBuscados.stream().filter(l -> l.getIdioma().equalsIgnoreCase(idioma)).collect(Collectors.toList());
	}
}
