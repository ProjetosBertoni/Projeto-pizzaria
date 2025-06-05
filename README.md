# 🍕 Projeto Pizzaria - Backend

Este repositório contém o **back-end** da aplicação web de uma pizzaria, desenvolvida durante a graduação em **Análise e Desenvolvimento de Sistemas**. O objetivo foi simular, com qualidade técnica, o funcionamento real de uma pizzaria — desde o cadastro de produtos até a realização de pedidos, com autenticação segura e controle de acesso por perfil.

## 👥 Equipe

-   **Felipe da Silva Bertoni Castelão** – Desenvolvimento Back-end com Java e Spring Boot
-   **Lucas Santos Machado**
-   **João Victor De Moraes Silva**

---

## ✅ Funcionalidades Implementadas

### 🔐 Autenticação e Segurança

-   Autenticação via **JWT** (stateless).
-   Cadastro de usuários com senhas criptografadas usando **BCrypt**.
-   Inclusão de **roles** no cadastro (ex: `ADMIN`, `CLIENTE`, `ATENDENTE`).
-   Geração de token contendo a role do usuário.
-   Filtro de segurança que intercepta requisições e valida o token.
-   Proteção de rotas de acordo com o perfil do usuário.

### 📦 Funcionalidade de Pedidos

-   Entidade `Pedido` associada a `Produto` e `Usuário`.
-   Registro de pedidos com múltiplos itens selecionados.
-   Validações com `@Valid` e controle de erros.
-   Integração com JWT para associar pedidos ao cliente logado.
-   **Permissões**: Apenas usuários autenticados com as roles `CLIENTE`, `ATENDENTE` ou `ADMIN` podem realizar pedidos.

> Essa funcionalidade é essencial para simular o fluxo real de uma pizzaria — desde a escolha do produto até a finalização do pedido — sempre com segurança e organização.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**  
- **Spring Boot 3.4.5**  
- Spring Web  
- Spring Data JPA  
- Spring Security  
- Bean Validation  
- Lombok  
- Spring Boot DevTools  
- Banco de Dados H2 (ambiente de desenvolvimento)  
- JWT (com a biblioteca `com.auth0:java-jwt:4.4.0`)

---

## 🧪 Endpoints Principais (Exemplos)

| Método | Endpoint                    | Descrição                                         | Exemplo de Body                                                                 |
| :----- | :-------------------------- | :------------------------------------------------ | :------------------------------------------------------------------------------ |
| `POST` | `/auth/login`               | Autentica o usuário e gera token JWT              | ```json {"email": "felipebertoni@gmail.com", "password": "12345"} ```            |
| `POST` | `/auth/register`            | Registra um novo usuário                          | ```json {"name":"Felipe Bertoni", "email": "felipebertoni@gmail.com", "password": "12345", "role": "ADMIN"} ``` |
| `GET`  | `/gerenciador/listar-usuarios` | Lista todos os usuários                           | N/A                                                                             |
| `POST` | `/gerenciador/removerPerfil`| Remove o perfil de um usuário                     | ```json {"email": "felipebertoni@gmail.com"} ```                               |
| `POST` | `/pizzas`                   | Adiciona um novo produto                          | ```json { "nome": "Fanta", "sabor": "Uva", "preco": 7, "categoria": "BEBIDA" } ``` |
| `DELETE`| `/pizzas/{id}`              | Remove um produto pelo ID                         | N/A                                                                             |
| `PUT`  | `/pizzas/{id}`              | Atualiza um produto pelo ID                       | ```json {"nome": "Fanta", "sabor": "Laranja", "preco": 10.50} ```              |
| `GET`  | `/pizzas`                   | Lista todos os produtos                           | N/A                                                                             |
| `POST` | `/pedidos`                  | Cria um novo pedido (requer autenticação)         | ```json { "itens": [ { "produtoId": 1, "quantidade": 2 }, { "produtoId": 2, "quantidade": 1 } ] } ``` |
| `GET`  | `/pedidos`                  | Lista os pedidos feitos pelo usuário autenticado  | N/A                                                                             |

> **Observação**: Para acessar rotas protegidas, utilize o token JWT no header das requisições (ex: `Authorization: Bearer <seu_token_jwt>`).
