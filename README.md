Biblioteca Digital - Documentação do Projeto


*Introdução*

Este projeto tem como objetivo modernizar a gestão de bibliotecas municipais por meio de um sistema digital
desenvolvido com Java e Spring Boot, oferecendo operações completas de CRUD para livros.


*Tecnologias Utilizadas*

- Java 11+
- Spring Boot 2.7.9
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- SLF4J
- RESTful API


*Como Executar*

1. Clone o repositório:
 git clone https://github.com/seu-usuario/biblioteca-digital.git
 cd biblioteca-digital
2. Execute com Maven:
 mvn spring-boot:run
3. Acesse:
 http://localhost:8080/


*Endpoints Disponíveis*

GET / - Verifica se a API está online
GET /livros - Lista todos os livros
POST /livros - Adiciona um novo livro
PUT /livros/{id} - Atualiza um livro
DELETE /livros/{id} - Remove um livro


*Exemplo de JSON*

 "titulo": "Dom Casmurro",
 "autor": "Machado de Assis",
  "anoPublicacao": 1899


*Configuração do Banco (H2)*
spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true