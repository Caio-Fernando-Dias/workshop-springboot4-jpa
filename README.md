# Web Services com Spring Boot e JPA / Hibernate

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white" />
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white" />
  <img src="https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white" />
  <img src="https://img.shields.io/badge/H2_Database-4479A1?style=for-the-badge&logo=hibernate&logoColor=white" />
</div>

## Sobre o Projeto
Este projeto é uma API RESTful completa desenvolvida em **Java** utilizando **Spring Boot** e **JPA / Hibernate**. Ele implementa um sistema de web services (e-commerce simplificado) com operações de CRUD (Create, Read, Update, Delete) bem estruturadas.

O projeto foca no uso de boas práticas do ecossistema Spring, modelagem de banco de dados relacional, mapeamento ORM, tratamento global de exceções e uso de perfis de configuração (test, dev, etc.).

## Tecnologias Utilizadas
* **Linguagem:** Java 25
* **Framework:** Spring Boot 4.1.0, Spring MVC, Spring Data JPA
* **Bancos de Dados:** H2 Database (para testes locais em memória) e PostgreSQL (banco relacional principal)
* **Gerenciador de Dependências:** Maven

## Funcionalidades
* **Gerenciamento de Entidades:** CRUD completo para a entidade `User` (Usuários).
* **Consultas de Relacionamentos:** Leitura e associação de entidades complexas do domínio de e-commerce: `Order` (Pedidos), `Product` (Produtos), `Category` (Categorias), `Payment` (Pagamentos) e `OrderItem` (Itens de Pedido).
* **Mapeamento ORM:** Utilização pesada do Hibernate para relacionamentos (1:1, 1:N, N:N).
* **Tratamento de Exceções:** Sistema de exceptions personalizadas e interceptadas de forma global (Ex: `ResourceNotFoundException`, `DatabaseException`) que retornam respostas JSON padronizadas usando `@ControllerAdvice`.
* **Database Seeding:** População automática de dados para ambiente de teste via configuração de banco H2.

## Estrutura da Aplicação
A aplicação segue um padrão rígido de camadas:
* `Resource / Controller`: Controladores REST (`UserResource`, etc.) que gerenciam as rotas, códigos de status HTTP e os retornos em JSON.
* `Service`: Camada de regras de negócio (`UserService`, etc.), centralizando a lógica antes de interagir com o banco de dados.
* `Repository`: Interfaces estendendo `JpaRepository`, responsáveis pelo acesso direto aos dados.
* `Entity`: Classes de domínio (`User`, `Product`, etc.) mapeadas com anotações `@Entity` e `@Table` refletindo o banco de dados relacional.
* `Exceptions`: Pacotes dedicados para capturar e formatar erros customizados (`ResourceExceptionHandler`).

## Como Executar Localmente

### 1. Requisitos
Você precisará ter o **Java 25** e o **Maven** instalados na sua máquina.

### 2. Configuração do Banco de Dados (Teste Local)
Por padrão, caso esteja rodando o perfil `test`, a aplicação utiliza o banco em memória **H2 Database**. Ao iniciar a aplicação, as tabelas serão automaticamente criadas e populadas (seeding) sem a necessidade de um banco externo configurado localmente.

### 3. Executando a Aplicação
Navegue até a pasta raiz do projeto (onde está o `pom.xml`) e execute via terminal:
```bash
./mvnw spring-boot:run
```

### 4. Acesso e Teste da API
A aplicação subirá na porta padrão `8080`.
Você pode testar as rotas da API em clientes REST como **Postman** ou **Insomnia**:
* `GET http://localhost:8080/users` - Lista todos os usuários.
* `GET http://localhost:8080/users/1` - Busca o usuário de id 1.
* `GET http://localhost:8080/orders` - Lista os pedidos.
* O console do H2 Database (caso habilitado no properties) poderá ser acessado pelo navegador.
