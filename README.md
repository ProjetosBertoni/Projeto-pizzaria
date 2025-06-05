# 🍕 Projeto Pizzaria - Backend

Este é o repositório do **back-end** da aplicação web de uma pizzaria, desenvolvida durante a graduação em **Análise e Desenvolvimento de Sistemas**, com o objetivo de simular, com qualidade técnica, o funcionamento real de uma pizzaria — desde o cadastro de produtos até a realização de pedidos, com autenticação segura e controle de acesso por perfil.

## 👥 Equipe

- **Felipe da Silva Bertoni Castelão** – Desenvolvimento Back-end com Java e Spring Boot  
- **Lucas Santos Machado**  
- **João Victor De Moraes Silva**

---

## ✅ Funcionalidades implementadas

### 🔐 Autenticação e segurança
- Autenticação via **JWT** (stateless)
- Cadastro de usuários com senhas criptografadas usando **BCrypt**
- Inclusão de **roles** no cadastro (ex: `ADMIN`, `CLIENTE`, `ATENDENTE`)
- Geração de token contendo a role do usuário
- Filtro de segurança interceptando requisições e validando o token
- Proteção de rotas de acordo com o perfil do usuário

### 📦 Funcionalidade de Pedidos
- Entidade `Pedido` associada a `Produto` e `Usuário`
- Registro de pedidos com múltiplos itens selecionados
- Validações com `@Valid` e controle de erros
- Integração com JWT para associar pedidos ao cliente logado
- Permissões:
  - Apenas usuários autenticados com roles `CLIENTE`, `ATENDENTE` ou `ADMIN` podem realizar pedidos


> Essa funcionalidade é essencial para simular o fluxo real de uma pizzaria — desde a escolha do produto até a finalização do pedido — sempre com segurança e organização.

---

## 🛠️ Tecnologias utilizadas

- **Java 21**  
- **Spring Boot 3.4.5**  
- Spring Web  
- Spring Data JPA  
- Bean Validation  
- Lombok  
- Spring Boot DevTools  
- Banco de Dados H2 (ambiente de desenvolvimento)

---

## 🧪 Endpoints principais (exemplos)

| Método | Endpoint             | Descrição                                |
|--------|----------------------|------------------------------------------|
| POST   | `/auth/login`        | Autentica o usuário e gera token JWT     |
{
	"email": "felipebertoni@gmail.com",
	"password": "12345"
}
| POST   | `/auth/register`     | registra o usuário                       |
{
	"name":"Felipe Bertoni",
	"email": "felipebertoni@gmail.com",
	"password": "12345",
	"role": "ADMIN"
}
| GET    | `/gerenciador/listar-usuarios`     | Lista os usuários          |

| POST   | `/gerenciador/removerPerfil`          | remove o perfil         |
{
	"email": "felipebertoni@gmail.com"
}
| POST   | `/pizzas`            | Adiciona o produto                       |
{
  "nome": "Fanta",
  "sabor": "Uva",
  "preco": 7,
  "categoria": "BEBIDA"
}
| DEL    | `/pizzas/{id}`       | remove o produto pelo ID                 |

| PUT    | `/pizzas/{id}`       | Atualiza o produto pelo {ID}             |
{
	"nome": "Fanta",
	"sabor": "Laranja",
	"preco": 10.50
}
| GET    | `/pizzas`            | Lista os produtos                        |

| POST   | `/pedidos`           | Cria novo pedido (requer autenticação)   |
{
  "itens": [
    { "produtoId": 1, "quantidade": 2 },
    { "produtoId": 2, "quantidade": 1 }
  ]
}
| GET   | `/pedidos`           | Lista os pedidos feito pelo usuario       |


> Use o token JWT no header das requisições para acessar rotas protegidas:
