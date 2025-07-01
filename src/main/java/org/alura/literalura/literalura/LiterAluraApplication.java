package org.alura.literalura.literalura;

import java.util.List;
import java.util.Scanner;

import org.alura.literalura.literalura.entity.AutorEntity;
import org.alura.literalura.literalura.repository.AutorRepository;
import org.alura.literalura.literalura.repository.LivroRepository;
import org.alura.literalura.literalura.service.CatalogoService;
import org.alura.literalura.literalura.service.GutendexService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiterAluraApplication implements CommandLineRunner {

	private final LivroRepository livroRepository;
	private final AutorRepository autorRepository;

	public LiterAluraApplication(LivroRepository livroRepository, AutorRepository autorRepository) {
		this.livroRepository = livroRepository;
		this.autorRepository = autorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiterAluraApplication.class, args);
	}

	@Override
	public void run(String... args) {
		menu();
	}

	private void menu() {
		Scanner scanner = new Scanner(System.in);
		GutendexService service = new GutendexService();
		CatalogoService catalogo = new CatalogoService();

		int opcao = -1;

		while (opcao != 0) {
			System.out.println("\n📚 MENU LITERALURA");
			System.out.println("1 - Buscar livros por autor");
			System.out.println("2 - Buscar livros por título");
			System.out.println("3 - Listar todos os livros buscados");
			System.out.println("4 - Buscar livros por idioma");
			System.out.println("5 - Listar autores registrados");
			System.out.println("6 - Buscar autores vivos em um ano específico");
			System.out.println("7 - Mostrar quantidade de livros por idioma");
			System.out.println("0 - Sair");
			System.out.print("Escolha uma opção: ");

			try {
				opcao = Integer.parseInt(scanner.nextLine());

				switch (opcao) {
				case 1 -> {
					System.out.print("Digite o nome do autor: ");
					String autor = scanner.nextLine();
					service.buscarLivros(autor).getLivros().forEach(System.out::println);
				}
				case 2 -> {
					System.out.print("Digite o título do livro: ");
					String titulo = scanner.nextLine();
					var resultado = service.buscarLivros(titulo).getLivros();
					if (!resultado.isEmpty()) {
						var livro = resultado.get(0);
						catalogo.adicionarLivro(livro);
						System.out.println(livro);
					} else {
						System.out.println("❌ Nenhum livro encontrado com esse título.");
					}
				}
				case 3 -> {
					var lista = catalogo.listarTodos();
					if (lista.isEmpty()) {
						System.out.println("📭 Nenhum livro foi adicionado ainda.");
					} else {
						lista.forEach(System.out::println);
					}
				}

				case 4 -> {
					System.out.print("Digite o idioma (ex: en, pt, fr): ");
					String idioma = scanner.nextLine();
					var encontrados = catalogo.buscarPorIdioma(idioma);
					if (encontrados.isEmpty()) {
						System.out.println("🔍 Nenhum livro encontrado com esse idioma.");
					} else {
						encontrados.forEach(System.out::println);
					}
				}
				case 5 -> {
					var autores = catalogo.listarAutores();
					if (autores.isEmpty()) {
						System.out.println("📭 Nenhum autor registrado.");
					} else {
						autores.forEach(System.out::println);
					}
				}
				case 6 -> {
					System.out.print("Informe o ano: ");
					int ano = Integer.parseInt(scanner.nextLine());
					List<AutorEntity> vivos = autorRepository.findByFalecimentoIsNullOrFalecimentoGreaterThanEqual(ano);
					if (vivos.isEmpty()) {
						System.out.println("❌ Nenhum autor vivo nesse ano.");
					} else {
						vivos.forEach(System.out::println);
					}
				}
				case 7 -> {
					System.out.print("Digite o idioma para buscar a quantidade de livros (ex: pt, en): ");
					String idioma = scanner.nextLine();
					long total = livroRepository.contarPorIdioma(idioma);
					System.out.println("Quantidade de livros no idioma '" + idioma + "': " + total);
				}
				case 0 -> System.out.println("Encerrando o programa...");
				default -> System.out.println("⚠️ Opção inválida. Tente novamente.");
				}

			} catch (NumberFormatException e) {
				System.out.println("⚠️ Digite um número válido.");
			} catch (Exception e) {
				System.out.println("❌ Erro ao executar operação: " + e.getMessage());
			}
		}

		scanner.close();
	}

}
