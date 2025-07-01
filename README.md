# 📚 Literalura Challenge Java

Projeto desenvolvido para o desafio do Oracle ONE - Java, com foco na criação de um catálogo de livros e autores utilizando Spring Boot, PostgreSQL e integração com a API pública [Gutendex](https://gutendex.com/books/).

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3.5.3
- Spring Data JPA
- PostgreSQL
- Biblioteca Jackson para manipulação JSON
- Maven para gerenciamento de dependências
- API Gutendex (https://gutendex.com/books/)

---

## 🎯 Objetivos do Projeto

- Consultar livros e autores através da API Gutendex.
- Mapear a resposta JSON para objetos Java utilizando Jackson.
- Persistir dados de livros e autores em banco de dados PostgreSQL via Spring Data JPA.
- Oferecer funcionalidades ao usuário via menu de linha de comando (CLI):
  - Buscar livros por título e autor
  - Listar todos os livros buscados
  - Buscar livros por idioma
  - Listar autores cadastrados
  - Listar autores vivos em um determinado ano
  - Exibir quantidade de livros por idioma

---

## ⚙️ Como Rodar o Projeto

### Pré-requisitos

- Java JDK 17 ou superior
- Maven instalado
- Banco de dados PostgreSQL configurado e em execução

Crie o arquivo `application.properties` em `src/main/resources` com as configurações:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/literalura
spring.datasource.username=SEU_USUARIO
spring.datasource.password=SUA_SENHA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.show-sql=true
