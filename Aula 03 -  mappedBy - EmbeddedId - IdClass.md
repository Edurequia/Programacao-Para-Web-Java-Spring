# Aula 03 - mappedBy, EmbeddedId e IdClass

## `mappedBy`
O atributo `mappedBy` no JPA é usado para indicar o lado **não proprietário** de um relacionamento bidirecional. Ele deve ser colocado no lado da relação que **não possui a chave estrangeira** no banco de dados.

### Relacionamento 1-N (Um para Muitos)
Neste relacionamento, uma entidade "pai" tem uma lista de entidades "filhas". A chave estrangeira normalmente fica na tabela da entidade "filha".

#### Exemplo:
```java
@Entity
public class Departamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;
}

@Entity
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToOne
    @JoinColumn(name = "departamento_id")
    private Departamento departamento;
}
```

📌 **Explicação:** A chave estrangeira (`departamento_id`) está na tabela `Funcionario`, tornando-o o lado proprietário. `Departamento` apenas referencia essa relação.

---

### Relacionamento 1-1 (Um para Um)
Neste caso, uma entidade está relacionada a outra de forma exclusiva. A chave estrangeira pode ficar em qualquer lado.

#### Exemplo:
```java
@Entity
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToOne(mappedBy = "pessoa")
    private Passaporte passaporte;
}

@Entity
public class Passaporte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numero;
    
    @OneToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;
}
```
📌 **Explicação:** A chave estrangeira (`pessoa_id`) está na entidade `Passaporte`, tornando-a o lado proprietário.

---

### Relacionamento N-N (Muitos para Muitos)
Neste caso, uma terceira tabela intermediária é criada automaticamente para armazenar as associações.

#### Exemplo:
```java
@Entity
public class Estudante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToMany(mappedBy = "estudantes")
    private List<Curso> cursos;
}

@Entity
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToMany
    @JoinTable(
        name = "estudante_curso",
        joinColumns = @JoinColumn(name = "curso_id"),
        inverseJoinColumns = @JoinColumn(name = "estudante_id")
    )
    private List<Estudante> estudantes;
}
```
📌 **Explicação:** `Curso` é o lado proprietário, pois define a `@JoinTable`.

---

## `@EmbeddedId` - Chave Primária Composta

### Caso 1: Entidade Fraca (`Dependente`)
No relacionamento entre `Colaborador` e `Dependente`, a chave primária do dependente **depende** da chave primária do colaborador.

#### Exemplo:
```java
@Embeddable
public class DependenteId implements Serializable {
    private Long colaboradorId;
    private String nome;
}

@Entity
public class Colaborador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @OneToMany(mappedBy = "colaborador")
    private List<Dependente> dependentes;
}

@Entity
public class Dependente {
    @EmbeddedId
    private DependenteId id;

    @ManyToOne
    @MapsId("colaboradorId")
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;
}
```

---

### Caso 2: Relacionamento N-N (`Colaborador <-> Projeto`)
Criamos uma entidade intermediária para armazenar a relação.

#### Exemplo:
```java
@Embeddable
public class ColaboradorProjetoId implements Serializable {
    private Long colaboradorId;
    private Long projetoId;
}

@Entity
public class Colaborador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @OneToMany(mappedBy = "colaborador")
    private List<ColaboradorProjeto> projetos;
}

@Entity
public class Projeto {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @OneToMany(mappedBy = "projeto")
    private List<ColaboradorProjeto> colaboradores;
}

@Entity
public class ColaboradorProjeto {
    @EmbeddedId
    private ColaboradorProjetoId id;

    @ManyToOne
    @MapsId("colaboradorId")
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    @ManyToOne
    @MapsId("projetoId")
    @JoinColumn(name = "projeto_id")
    private Projeto projeto;
}
```

---

## `@IdClass` - Alternativa para Chaves Compostas
Outra abordagem é usar `@IdClass`, onde os IDs são definidos diretamente na entidade.

#### Exemplo:
```java
public class DependenteId implements Serializable {
    private Long colaboradorId;
    private String nome;
}

@Entity
@IdClass(DependenteId.class)
public class Dependente {
    @Id
    private Long colaboradorId;
    @Id
    private String nome;

    @ManyToOne
    @JoinColumn(name = "colaboradorId", insertable = false, updatable = false)
    private Colaborador colaborador;
}
```

📌 **Diferença:** `@IdClass` define os IDs separadamente na entidade, enquanto `@EmbeddedId` encapsula-os em um objeto único.

---

## 🚀 **Conclusão: `@EmbeddedId` vs `@IdClass`**
| Característica | `@EmbeddedId` | `@IdClass` |
|---------------|--------------|------------|
| Definição da chave | Classe embutida (`@Embeddable`) | Classe separada |
| Onde define os IDs? | Em uma única variável dentro da entidade | Como atributos individuais da entidade |
| Relacionamentos | Usa `@MapsId` para vincular FKs | Usa `@JoinColumn(insertable = false, updatable = false)` |
| Organização | Mais reutilizável e encapsulado | Mais explícito e direto |

📌 **Quando usar qual?**
- Use `@EmbeddedId` se quiser **encapsular** a chave primária e manter código mais modular.
- Use `@IdClass` se quiser uma **implementação mais direta** e não precisar reutilizar a chave composta.

Ambas são válidas e dependem do estilo que você prefere no projeto. 🚀💡
