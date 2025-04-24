# 🧪 Avaliação Prática – Programação para Web (Java + Spring Boot + JPA + MySQL)

## 🧩 Enunciado

Você deverá desenvolver uma API utilizando **Java com Spring Boot**, **JPA** e **MySQL**, simulando um sistema de **registro de vendas**. O sistema permitirá o **cadastro de produtos, clientes** e o **registro de vendas**, com cálculo automático do total da venda (incluindo desconto, se houver).

A entrega consiste no desenvolvimento do backend completo com as funcionalidades descritas abaixo.

---

## 🎯 Funcionalidades

1. **Cadastro de Produtos**
2. **Cadastro de Clientes**
3. **Registro de Vendas**
   - Cada venda deve conter:
     - Um **cliente**
     - Uma **lista de itens** (produto + quantidade + valor unitário)
     - Um campo para **desconto percentual (%)**
     - Um campo calculado: **valor total da venda**, considerando desconto e subtotal dos itens

---

## 🧱 Tecnologias obrigatórias

- Java + Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Utilização de DTOs (`record` recomendado)
- Camadas bem definidas: Controller, Service, Repository, Entity, DTO

---

## 🧮 Critérios de Avaliação (Total: 10,0 pontos)

| Critério                                                                 | Peso     |
|--------------------------------------------------------------------------|----------|
| ✔️ CRUD completo e funcional de uma entidade (Cliente ou Produto)        | 5,0 pts  |
| ✔️ Registro funcional de uma venda com cálculo correto de total/desconto | 2,0 pts  |
| ✔️ Uso de DTOs organizados e bem estruturados                            | 1,0 pt   |
| ✔️ Camada de serviço com regras de negócio aplicadas corretamente        | 1,0 pt   |
| ✔️ Implementação de pelo menos uma consulta personalizada (JPA Query)   | 1,0 pt   |

---

## 🔧 Regras de Negócio

- O valor total da venda deve ser calculado com base em:
  ```
  total = soma(preço_unitário * quantidade) de cada item - desconto (se houver)
  ```
- Não deve ser permitido vender mais produtos do que há disponível no estoque.
- O valor total deve ser retornado no DTO de resposta da venda.

---

## 🔄 Exemplos de Requisições em JSON

Use os exemplos abaixo para testar a API com ferramentas como **Postman** ou **Insomnia**.

### 📦 Produto – Criar (POST)
```json
{
  "name": "Notebook Dell i5",
  "price": 3500.00,
  "quantity": 10
}
```

### 👤 Cliente – Criar (POST)
```json
{
  "name": "João da Silva",
  "email": "joao.silva@email.com",
  "cpf": "123.456.789-00"
}
```

### 🧾 Venda – Criar (POST)
```json
{
  "clientId": 1,
  "discount": 10,
  "items": [
    {
      "productId": 1,
      "quantity": 2
    },
    {
      "productId": 2,
      "quantity": 1
    }
  ]
}
```

### 🧾 Venda – Resposta (GET)
```json
{
  "id": 1,
  "client": {
    "id": 1,
    "name": "João da Silva",
    "cpf": "123.456.789-00"
  },
  "items": [
    {
      "productId": 1,
      "productName": "Notebook Dell i5",
      "quantity": 2,
      "unitPrice": 3500.00,
      "subTotal": 7000.00
    },
    {
      "productId": 2,
      "productName": "Monitor 24'' LG",
      "quantity": 1,
      "unitPrice": 1200.00,
      "subTotal": 1200.00
    }
  ],
  "discount": 10,
  "total": 7380.00,
  "createdAt": "2025-04-24T15:30:00"
}
```

---

## 🔍 Consultas Personalizadas Sugeridas (Query Methods)

Implemente pelo menos **uma** das consultas abaixo:

- Buscar produtos com estoque menor que um determinado valor.
- Buscar vendas de um cliente específico.
- Buscar produtos pelo nome (contendo uma palavra-chave).

---

## 📤 Entrega

- Suba o projeto no **GitHub pessoal** e compartilhe o link.
- O repositório deve conter:
  - Código-fonte organizado (Controller, Service, Repository, Entity, DTO)
  - `README.md` com instruções para rodar o projeto (configuração do banco, endpoints, etc.)
    
---
