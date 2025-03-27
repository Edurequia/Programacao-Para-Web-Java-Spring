# Data Transfer Object - DTO 

## 📦 O que é um DTO?

DTO significa **Data Transfer Object**, ou seja, **Objeto de Transferência de Dados**.

Ele é usado para:
- **Levar dados de um lugar para outro**, geralmente entre o **controller** e o **cliente (ex: front-end)**.
- **Evitar enviar entidades completas (modelos do banco)**, protegendo dados sensíveis ou evitando problemas de estrutura.
- **Facilitar o controle sobre o que entra e sai da API**.

---

## 🧩 Por que usar DTOs?

Imagine que sua entidade `User` tenha um campo chamado `senha`. Você não quer que isso seja retornado na resposta da API.  
Ou imagine que você quer exibir o nome do usuário **e os telefones formatados** juntos em uma única resposta. O DTO resolve isso!

---

## 🛠️ Estrutura no seu repositório

No repositório `UserPhoneAPI`, temos um exemplo de organização dos DTOs:

📁 `src/main/java/com/example/userphone/dto`

- `UserDTO.java`
- `PhoneDTO.java`

Esses DTOs são usados para transferir apenas os dados que você quer que **entrem** ou **saiam** da sua API.

---

### 👀 Exemplo prático: `UserDTO.java`

```java
public record UserDTO(Long id, String name, String email) {
}
```

Esse `record` representa apenas os dados que você quer expor de um `User`.

🔒 Repare que **não tem senha aqui** — isso protege a aplicação de retornar dados sensíveis.

---

## 🧭 Como utilizar um DTO na prática

1. **No Controller**, você usa o DTO para **receber ou retornar** dados.
2. **No Service**, você pode converter a entidade para DTO e vice-versa.

---

### 🔁 Exemplo de conversão: Entidade → DTO

```java
public UserDTO convertToDTO(User user) {
    return new UserDTO(user.getId(), user.getName(), user.getEmail());
}
```

---

### 🧍 Exemplo no `UserController`

```java
@GetMapping
public List<UserDTO> getAllUsers() {
    return userService.getAllUsers()
                      .stream()
                      .map(user -> new UserDTO(user.getId(), user.getName(), user.getEmail()))
                      .toList();
}
```

Aqui o controller **não retorna o `User` diretamente**, mas sim o `UserDTO`.

---

## ✏️ Exemplo com DTO de entrada (criação de usuário)

Você pode ter um DTO separado para entrada, ex:

```java
public record CreateUserDTO(String name, String email, String password) {}
```

E no controller:

```java
@PostMapping
public UserDTO createUser(@RequestBody CreateUserDTO dto) {
    User user = new User();
    user.setName(dto.name());
    user.setEmail(dto.email());
    user.setPassword(dto.password()); // só uso interno!

    return userService.createUser(user);
}
```

---

## 🧠 Benefícios de usar DTOs

| Vantagem | Descrição |
|---------|-----------|
| 🔐 Segurança | Evita expor dados sensíveis |
| 📦 Organização | Separa claramente entrada e saída |
| 🎯 Clareza | Define o que exatamente será transferido |
| 🔄 Flexibilidade | Permite compor objetos com dados de múltiplas fontes |

---

Perfeito, Professor Herysson! Aqui está a **atividade didática** com foco em **DTOs (Data Transfer Objects)** utilizando o repositório [UserPhoneAPI](https://github.com/Herysson/UserPhoneAPI).

---

## 🛠️ Atividade  

### 🎯 Objetivo:
Entender e aplicar o uso de **DTOs** para melhorar a organização, segurança e clareza na troca de dados entre o back-end e os consumidores da API.

---

### 📂 Repositório base:
[https://github.com/Herysson/UserPhoneAPI](https://github.com/Herysson/UserPhoneAPI)

---

### 🛠️ Tarefas:

Implemente os seguintes pontos relacionados à camada de transferência de dados (**DTOs**):

---

### ✅ 1. Criar um DTO de saída para **Phone**

- Nome sugerido: `PhoneDTO`
- Campos: `Long id`, `int ddd`, `String numero`
- Objetivo: retornar apenas os dados públicos do telefone

---

### ✅ 2. Criar um DTO de entrada para **criação de telefone**

- Nome sugerido: `CreatePhoneDTO`
- Campos: `int ddd`, `String numero`, `Long userId`
- Objetivo: controlar os dados recebidos na criação de um telefone (sem usar diretamente a entidade)

---

### ✅ 3. Alterar o `PhoneController` para:

- Receber dados via `CreatePhoneDTO` no endpoint `POST /phones`
- Retornar dados via `PhoneDTO` no endpoint `GET /phones`

> Dica: crie métodos auxiliares no `PhoneService` ou no `PhoneController` para converter entre entidade ↔ DTO.

---

