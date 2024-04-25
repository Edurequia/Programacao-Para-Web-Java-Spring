# Spring Backend CRUD

Spring Initializr [Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.4&packaging=jar&jvmVersion=17&groupId=com.example&artifactId=Spring-BackendCRUD&name=Spring-BackendCRUD&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.Spring-BackendCRUD&dependencies=web,devtools,lombok,data-jpa,mysql)

## Model - JPA - Lombok

Para criar as classes `User` e `Phone` utilizando as anotações do Lombok e do JPA para mapeamento do banco de dados, precisamos combinar as facilidades oferecidas pelo Lombok para reduzir o boilerplate com as anotações de mapeamento do JPA que definem como as classes e campos são mapeados para tabelas e colunas no banco de dados.

### Classe `User`

A classe `User` terá um relacionamento `OneToMany` com a classe `Phone`, indicando que um usuário pode ter vários telefones.

```java

@Entity
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Phone> phones;

    @Builder
    public User(String name, String email, List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.phones = phones;
    }
}
```

### Classe `Phone`

A classe `Phone` terá um relacionamento `ManyToOne` com `User`, indicando que cada telefone está associado a um usuário.

```java

@Entity
@Getter @Setter @NoArgsConstructor
public class Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String number;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    @Builder
    public Phone(String type, String number, User user) {
        this.type = type;
        this.number = number;
        this.user = user;
    }
}

```

### Explicação

- **Lombok**: Usamos `@Getter`, `@Setter`, e `@NoArgsConstructor` para gerar automaticamente getters, setters, e um construtor sem argumentos. Isso reduz significativamente o código boilerplate necessário para essas operações comuns.
  
- **JPA**:
  - `@Entity`: Especifica que a classe é uma entidade JPA.
  - `@Id`: Marca o campo como a chave primária da entidade.
  - `@GeneratedValue(strategy = GenerationType.IDENTITY)`: Define a estratégia de geração automática dos IDs das entidades. Neste caso, delegamos ao banco de dados a responsabilidade de gerar o ID, o que é comum com colunas autoincrementáveis.
  - `@OneToMany` e `@ManyToOne`: Definem o relacionamento entre as entidades `User` e `Phone`. `mappedBy` indica o campo da entidade proprietária do relacionamento.
  - `@JoinColumn`: Especifica a coluna usada para unir as entidades no relacionamento. No caso de `Phone`, é a coluna `user_id` que faz a referência ao `User` associado.

### Configuração Adicional

Para que essas classes sejam efetivamente mapeadas no banco de dados, é necessário configurar a fonte de dados e o provedor JPA no arquivo de configuração do seu projeto (por exemplo, `application.properties` ou `application.yml` para projetos Spring Boot).

```
#Update the database schema based on the entities create-drop / update
spring.jpa.hibernate.ddl-auto = update
#create database if not exists mysql true spring boot
spring.datasource.url=jdbc:mysql://localhost:3306/SPRING_CRUD?createDatabaseIfNotExist=true
#DB User
spring.datasource.username=root
#DB password
spring.datasource.password=laboratorio
```

## Controller

Para criar uma classe controller para a entidade `User` em um projeto Spring Boot, vamos seguir os padrões REST e utilizar algumas das anotações do Spring MVC. Este controller vai expor endpoints básicos para operações CRUD (Create, Read, Update, Delete) relacionadas a `User`.

```java
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Create a new User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.ok(newUser);
    }

    // Get all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return ResponseEntity.ok(users);
    }

    // Get a single User by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        User user = userService.findUserById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return ResponseEntity.ok(user);
    }

    // Update a User
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ResponseEntity.ok(updatedUser);
    }

    // Delete a User
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
```

### Explicação

- **`@RestController`**: Indica que a classe é um controller REST, e isso implica que os dados retornados por cada método serão escritos diretamente no corpo da resposta (response body) em formato JSON ou XML.
  
- **`@RequestMapping("/users")`**: Define o caminho base para todos os endpoints neste controller, o que significa que todos os caminhos de métodos começarão com `/users`.
  
- **`@PostMapping`, `@GetMapping`, `@PutMapping`, `@DeleteMapping`**: São anotações específicas que mapeiam os métodos HTTP POST, GET, PUT, e DELETE aos métodos no controller.
  
- **`@RequestBody User user`**: Indica que o parâmetro `user` deve ser vinculado ao corpo da solicitação (request body).
  
- **`@PathVariable Long id`**: Extrai o valor de `id` do caminho da URL.

### Considerações

- Este controller assume a existência de uma camada de serviço (`UserService`), que contém a lógica de negócios e interage com o repositório de dados. Isso é uma prática comum para manter o código organizado e facilitar a manutenção.

- A exceção `ResourceNotFoundException` seria uma exceção personalizada que você precisa definir para lidar com casos em que um recurso solicitado não é encontrado. É uma prática comum lançar essa exceção em métodos de serviço quando um recurso não pode ser recuperado, e ela pode ser anotada com `@ResponseStatus` para definir o código de status HTTP apropriado.

Essa estrutura de controller oferece um ponto de partida sólido para criar uma API RESTful para a entidade `User`, seguindo boas práticas e padrões de design.


##Service

Uma camada de serviço em uma aplicação, especialmente em arquiteturas de software como a Modelo-Visão-Controlador (MVC) ou em aplicações baseadas em microserviços, é uma abstração de código designada principalmente para conter a lógica de negócios da aplicação. Esta camada age como um mediador entre a interface do usuário (por exemplo, um controlador web em uma aplicação MVC) e a camada de acesso a dados (onde os dados são armazenados e recuperados).

### Propósito da Camada de Serviço

O principal objetivo da camada de serviço é orquestrar as operações de aplicação e implementar a lógica de negócios. Isso pode envolver operações como consultar um banco de dados através de um repositório, realizar cálculos, aplicar regras de negócios, e coordenar transações. A camada de serviço é responsável por garantir que os dados sejam apresentados e manipulados de forma que faça sentido para o negócio, abstraindo a complexidade das operações para as camadas superiores (por exemplo, os controladores).

### Características da Camada de Serviço

- **Abstração**: Oferece uma abstração da lógica de negócios e das operações sobre os dados, escondendo detalhes complexos das camadas superiores.
- **Reutilização**: Facilita a reutilização do código, uma vez que a mesma lógica de serviço pode ser utilizada por diferentes controladores ou componentes da aplicação.
- **Separação de Responsabilidades**: Ajuda a manter uma clara separação de responsabilidades no código, separando a lógica de negócios da lógica de apresentação e do acesso a dados.
- **Manutenção e Testabilidade**: Simplifica a manutenção e melhora a testabilidade da aplicação, pois isola a lógica de negócios em uma camada que pode ser testada independentemente da interface do usuário e da infraestrutura de armazenamento de dados.

### Exemplo

Considere uma aplicação web para gerenciamento de pedidos em uma loja. A camada de serviço pode conter métodos como `criarPedido`, `cancelarPedido`, e `atualizarStatusDoPedido`. Cada um desses métodos implementaria as regras de negócios relevantes (verificações de estoque, validações, atualizações de status, etc.) e interagiria com a camada de repositório para persistir as mudanças. Os controladores, que lidam com as requisições HTTP, chamariam esses métodos de serviço para executar as operações solicitadas, sem precisar conhecer os detalhes da implementação das regras de negócios ou como os dados são armazenados.

A camada de serviço é uma parte essencial da estrutura de muitas aplicações, permitindo uma organização de código mais limpa, flexível e manutenível. Ao encapsular a lógica de negócios e oferecer serviços reutilizáveis às outras partes da aplicação, facilita o desenvolvimento, a testabilidade e a manutenção do software.

### UserService

A classe `UserService` atua como a camada de serviço em uma aplicação Spring Boot, responsável pela lógica de negócios e pela comunicação entre o controller (`UserController`) e a camada de acesso a dados (tipicamente um repositório JPA). Esta camada abstrai a complexidade das operações de dados, fornecendo uma interface clara para o controller utilizar.

Vamos criar um exemplo de `UserService` que inclui métodos para as operações CRUD básicas.

### Exemplo de `UserService`

A classe UserService atua como a camada de serviço em uma aplicação Spring Boot, responsável pela lógica de negócios e pela comunicação entre o controller (UserController) e a camada de acesso a dados (tipicamente um repositório JPA). Esta camada abstrai a complexidade das operações de dados, fornecendo uma interface clara para o controller utilizar.


```java
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create a new user
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Find all users
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    // Find a user by ID
    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    // Update a user
    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPhones(userDetails.getPhones()); // Assumes setter copies the state (for simplicity)
        return userRepository.save(user);
    }

    // Delete a user
    public void deleteUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.delete(user);
    }
}
```

### Explicação

- **`@Service`**: Esta anotação marca a classe como um componente de serviço no contexto do Spring, indicando que ela contém a lógica de negócios.

- **Injeção de Dependência**: O `UserRepository` é injetado no `UserService` através do construtor, permitindo que o serviço acesse as operações de persistência definidas na interface do repositório.

- **Métodos do Serviço**:
  - **`createUser(User user)`**: Salva um novo usuário no banco de dados.
  - **`findAllUsers()`**: Recupera todos os usuários do banco de dados.
  - **`findUserById(Long id)`**: Busca um usuário por seu ID. Retorna um `Optional<User>` que pode ou não conter um usuário.
  - **`updateUser(Long id, User userDetails)`**: Atualiza as informações de um usuário existente. Primeiro, busca o usuário pelo ID, depois atualiza seus dados e salva as alterações no banco de dados.
  - **`deleteUser(Long id)`**: Exclui um usuário do banco de dados pelo ID.

- **Manuseio de Exceções**: No método `updateUser`, se o usuário com o ID fornecido não for encontrado, uma exceção `ResourceNotFoundException` (uma exceção personalizada que você deve criar) é lançada.

A classe `UserService` encapsula a lógica de negócios e interage diretamente com a camada de persistência, tornando o código mais organizado e mantendo a separação de responsabilidades. Isso facilita a manutenção e a testabilidade da aplicação. Ao abstrair a lógica de negócios e o acesso a dados do controller, você obtém uma arquitetura limpa e modular.

## Repository
A classe `UserRepository` em um projeto Spring Boot com Spring Data JPA não é uma classe no sentido tradicional, mas uma interface. Essa interface atua como a camada de persistência, abstraindo os detalhes do acesso a dados do banco de dados. O Spring Data JPA simplifica a implementação do padrão de repositório, permitindo que você defina interfaces que estendem uma das interfaces base do Spring Data, como `JpaRepository`, `CrudRepository`, ou `PagingAndSortingRepository`. Essas interfaces fornecem métodos prontos para diversas operações de CRUD (Create, Read, Update, Delete), além de permitir a definição de métodos de consulta personalizados de maneira declarativa.

### Exemplo de `UserRepository`

```java
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aqui você pode definir métodos de consulta personalizados, se necessário.
}
```

### Explicação

- **`@Repository`**: Anotação que indica que a interface é um repositório Spring, um mecanismo para encapsulamento de armazenamento, recuperação e busca de comportamento que emula uma coleção de objetos.

- **`JpaRepository<User, Long>`**: Ao estender `JpaRepository`, `UserRepository` herda uma série de métodos prontos para operações de CRUD e manipulação de entidades `User`. Os parâmetros genéricos `<User, Long>` indicam que esta interface de repositório lida com entidades do tipo `User` e que o tipo do ID da entidade é `Long`.

- **Personalização**: Embora este exemplo não mostre métodos de consulta personalizados, o Spring Data JPA permite que você defina tais métodos na interface do repositório. Você pode fazer isso simplesmente declarando a assinatura do método seguindo as convenções de nomenclatura do Spring Data JPA, ou usando a anotação `@Query` para especificar uma consulta JPQL ou SQL nativa.

### Benefícios do `UserRepository`

- **Simplicidade**: O Spring Data JPA gera a implementação em tempo de execução para os métodos herdados de `JpaRepository`. Isso elimina a necessidade de implementar manualmente um DAO (Data Access Object).
  
- **Poderoso e Flexível**: Fornece métodos prontos para uso para salvar, deletar, e buscar entidades. Além disso, suporta paginação e ordenação sem esforço adicional.
  
- **Consultas Declarativas**: Permite a criação de consultas personalizadas usando as convenções de nomenclatura do Spring ou a anotação `@Query`, tornando fácil adaptar o repositório às necessidades específicas da aplicação.

- **Integração**: Funciona perfeitamente com o ecossistema Spring, incluindo transações e configurações de cache, fornecendo uma integração suave com outras partes de uma aplicação Spring.

A criação de um `UserRepository` é um passo fundamental na construção de uma aplicação Spring Boot que utiliza Spring Data JPA para interagir com o banco de dados, simplificando significativamente a camada de acesso a dados.

## Resource

A classe `ResourceNotFoundException` é uma exceção personalizada usada em aplicações Spring Boot para indicar que um recurso específico, tal como um usuário ou produto, não foi encontrado. Em uma arquitetura REST, é comum lançar essa exceção quando uma operação de busca por um determinado recurso pelo seu identificador retorna vazio, por exemplo, ao tentar encontrar um usuário em um banco de dados que não existe. Esta exceção pode ser usada junto com um manipulador de exceções global para retornar uma resposta adequada ao cliente, como um status HTTP 404 Not Found.

### Exemplo de Implementação da `ResourceNotFoundException`

```java
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
```

### Explicação

- **`@ResponseStatus(value = HttpStatus.NOT_FOUND)`**: Esta anotação é usada para marcar a exceção `ResourceNotFoundException` com o status HTTP que deve ser retornado. Quando essa exceção é lançada, o Spring automaticamente retorna uma resposta com o status `404 Not Found` para o cliente. Isso informa ao cliente que o recurso solicitado não pôde ser encontrado.

- **Construtor com Mensagem**: O construtor permite que você passe uma mensagem personalizada que pode descrever mais detalhadamente o erro. Por exemplo, você pode incluir o ID do recurso que estava sendo buscado para facilitar a depuração.

### Uso da `ResourceNotFoundException`

Vamos ver como `ResourceNotFoundException` pode ser utilizada dentro do serviço `UserService`:

```java
public User findUserById(Long id) {
    return userRepository.findById(id)
                         .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
}
```

Neste exemplo, se o método `findById` do `UserRepository` não encontrar um usuário com o ID fornecido, ele retorna um `Optional.empty()`. O método `orElseThrow` é então usado para lançar uma `ResourceNotFoundException` se o resultado estiver vazio.

### Benefícios

- **Clareza e Consistência**: Usar uma exceção personalizada como `ResourceNotFoundException` para lidar com casos de recursos não encontrados torna o código mais claro e consistente. Isso facilita a manutenção e compreensão do código, especialmente em grandes projetos.

- **Personalização de Respostas**: A capacidade de personalizar a mensagem de erro e o status de resposta HTTP torna a API mais informativa e útil para os consumidores.

- **Facilidade de Uso com Spring**: Combinado com o sistema de exceções do Spring e o manipulador de exceções global (por exemplo, usando `@ControllerAdvice`), `ResourceNotFoundException` pode ser uma parte poderosa da gestão de erros em sua aplicação Spring Boot.

Esta abordagem para lidar com erros e exceções em aplicações Spring Boot ajuda a criar APIs RESTful mais robustas e amigáveis ao usuário, proporcionando feedback claro quando os recursos solicitados não são encontrados.
