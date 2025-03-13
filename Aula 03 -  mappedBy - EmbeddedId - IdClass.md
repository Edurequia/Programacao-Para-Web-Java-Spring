# `mappedBy`

O atributo `mappedBy` no JPA é usado para indicar o lado **não proprietário** de um relacionamento bidirecional. Ele deve ser colocado no lado da relação que **não possui a chave estrangeira** no banco de dados. Aqui estão os três exemplos e onde o `mappedBy` deve ser colocado:

---

### 1. Relacionamento **1-N** (Um para Muitos)
Neste relacionamento, uma entidade "pai" tem uma lista de entidades "filhas". A chave estrangeira normalmente fica na tabela da entidade "filha".

#### Exemplo:
```java
@Entity
public class Departamento {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToMany(mappedBy = "departamento")  // O lado não proprietário (não contém a FK)
    private List<Funcionario> funcionarios;
}

@Entity
public class Funcionario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToOne  // O lado proprietário (contém a FK)
    @JoinColumn(name = "departamento_id") 
    private Departamento departamento;
}
```
📌 **Por que `mappedBy` está em `Departamento`?**  
Porque a chave estrangeira (`departamento_id`) está na tabela `Funcionario`. Logo, `Funcionario` é o lado proprietário da relação, e `Departamento` apenas referencia essa relação.

---

### 2. Relacionamento **1-1** (Um para Um)
Neste caso, uma entidade está relacionada a outra de forma exclusiva. A chave estrangeira pode ficar em qualquer lado.

#### Exemplo:
```java
@Entity
public class Pessoa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToOne(mappedBy = "pessoa")  // O lado não proprietário (não contém a FK)
    private Passaporte passaporte;
}

@Entity
public class Passaporte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String numero;
    
    @OneToOne  // O lado proprietário (contém a FK)
    @JoinColumn(name = "pessoa_id") 
    private Pessoa pessoa;
}
```
📌 **Por que `mappedBy` está em `Pessoa`?**  
Porque a chave estrangeira (`pessoa_id`) está em `Passaporte`, tornando `Passaporte` o lado proprietário.

---

### 3. Relacionamento **N-N** (Muitos para Muitos)
Neste caso, uma terceira tabela intermediária é criada automaticamente para armazenar as associações. Quando temos um **relacionamento bidirecional**, usamos `mappedBy` para definir o lado não proprietário.

#### Exemplo:
```java
@Entity
public class Estudante {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @ManyToMany(mappedBy = "estudantes")  // O lado não proprietário
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
📌 **Por que `mappedBy` está em `Estudante`?**  
Porque a anotação `@JoinTable` define a tabela intermediária no lado `Curso`, tornando `Curso` o lado proprietário da relação.

---

### 🔥 Resumo Rápido:
| Tipo de Relacionamento | Onde colocar `mappedBy`? | Quem contém a FK? |
|------------------------|--------------------------|--------------------|
| **1-N (Um para Muitos)** | No `@OneToMany` (lado que tem a lista) | No lado `@ManyToOne` |
| **1-1 (Um para Um)** | No `@OneToOne` do lado não proprietário | No lado `@OneToOne` com `@JoinColumn` |
| **N-N (Muitos para Muitos)** | No `@ManyToMany` do lado não proprietário | No lado que define `@JoinTable` |


### 🔥 Criando uma **Chave Primária Composta** com `@EmbeddedId` no JPA

No JPA, podemos definir uma **chave primária composta** de duas maneiras principais:

1. **Usando `@IdClass`** – Define uma classe separada para a chave composta.
2. **Usando `@EmbeddedId`** – Define um objeto embutido como chave primária (mais recomendado).

Aqui, utilizaremos **`@EmbeddedId`**, pois mantém o código mais organizado e reutilizável.

---

# `@EmbeddedId` 

## **Caso 1: Chave Primária Composta em uma Entidade Fraca (`Dependente`)**
No relacionamento entre `Colaborador` e `Dependente`, a chave primária do dependente **depende** da chave primária do colaborador. Para isso:

- Criamos uma **classe embutida** para a chave composta (`DependenteId`).
- Utilizamos `@EmbeddedId` para marcar essa chave na entidade `Dependente`.
- Utilizamos `@MapsId` para mapear a relação com `Colaborador`.

### **Exemplo:**
#### 1. Criando a Classe de Chave Composta (`DependenteId`)
```java
@Embeddable
public class DependenteId implements Serializable {
    private Long colaboradorId;
    private String nome;
}
```

#### 2. Criando a Entidade `Colaborador`
```java
@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    
    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Dependente> dependentes;
}
```

#### 3. Criando a Entidade `Dependente` com `@EmbeddedId`
```java
@Entity
public class Dependente {
    @EmbeddedId
    private DependenteId id;

    @ManyToOne
    @MapsId("colaboradorId") // Mapeia a FK a partir do @EmbeddedId
    @JoinColumn(name = "colaborador_id")
    private Colaborador colaborador;

    private Integer idade;
}
```

📌 **Explicação:**  
- `DependenteId` contém **colaboradorId + nome** como chave primária composta.
- `Dependente` usa `@EmbeddedId` para a chave primária.
- `@MapsId("colaboradorId")` indica que `colaboradorId` vem do relacionamento com `Colaborador`.

---

##  **Caso 2: Chave Primária Composta no Relacionamento N-N (`Colaborador <-> Projeto`)**
No relacionamento **Muitos-para-Muitos**, criamos uma **entidade intermediária** (`ColaboradorProjeto`) para armazenar a relação.

- Criamos `ColaboradorProjetoId` como chave composta.
- Definimos `@EmbeddedId` na entidade de junção (`ColaboradorProjeto`).
- Usamos `@ManyToOne` com `@MapsId`.

### **Exemplo:**
#### 1 Criando a Classe da Chave Composta (`ColaboradorProjetoId`)
```java
@Embeddable
public class ColaboradorProjetoId implements Serializable {
    private Long colaboradorId;
    private Long projetoId;
}
```

#### 2 Criando a Entidade `Colaborador`
```java
@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<ColaboradorProjeto> projetos;
}
```

#### 3 Criando a Entidade `Projeto`
```java
@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<ColaboradorProjeto> colaboradores;
}
```

#### 4 Criando a Entidade Intermediária `ColaboradorProjeto`
```java
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

    private String papel;
}
```

📌 **Explicação:**  
- Criamos a entidade intermediária `ColaboradorProjeto` para representar a relação `N-N`.
- `@EmbeddedId` é usado em `ColaboradorProjeto` para representar a chave composta.
- `@MapsId` vincula `colaboradorId` e `projetoId` às respectivas entidades.

---

## 🚀 **Conclusão**
| Situação | Solução |
|----------|---------|
| Entidade Fraca (`Dependente`) | `@EmbeddedId` + `@MapsId` no relacionamento `@ManyToOne` |
| Relacionamento `N-N` (`Colaborador <-> Projeto`) | Criamos uma entidade intermediária e usamos `@EmbeddedId` |


---
# `@IdClass`
### 📌 **Como funciona `@IdClass`?**
- Criamos uma **classe auxiliar** que representa a chave primária composta.
- Utilizamos `@IdClass` na entidade para indicar que a chave primária será composta por múltiplos campos.

---

## 🏢 **Caso 1: Chave Primária Composta em `Dependente`**
#### 1️⃣ Criando a Classe `DependenteId`
```java
import java.io.Serializable;
import java.util.Objects;

public class DependenteId implements Serializable {
    private Long colaboradorId;
    private String nome;

    public DependenteId() {}

    public DependenteId(Long colaboradorId, String nome) {
        this.colaboradorId = colaboradorId;
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DependenteId that = (DependenteId) o;
        return Objects.equals(colaboradorId, that.colaboradorId) &&
               Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colaboradorId, nome);
    }
}
```

#### 2️⃣ Criando a Entidade `Colaborador`
```java
@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<Dependente> dependentes;
}
```

#### 3️⃣ Criando a Entidade `Dependente` com `@IdClass`
```java
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

    private Integer idade;
}
```

📌 **Explicação:**
- `@IdClass(DependenteId.class)` informa que os campos `colaboradorId` e `nome` formam a chave primária.
- Os campos `@Id` são definidos na própria entidade `Dependente`.
- O relacionamento com `Colaborador` é feito com `@ManyToOne`, mas as colunas `colaboradorId` e `nome` não são atualizáveis diretamente, pois fazem parte da PK.

---

### 🔗 **Caso 2: Chave Primária Composta no Relacionamento N-N (`Colaborador <-> Projeto`)**
#### 1️⃣ Criando a Classe `ColaboradorProjetoId`
```java
import java.io.Serializable;
import java.util.Objects;

public class ColaboradorProjetoId implements Serializable {
    private Long colaboradorId;
    private Long projetoId;

    public ColaboradorProjetoId() {}

    public ColaboradorProjetoId(Long colaboradorId, Long projetoId) {
        this.colaboradorId = colaboradorId;
        this.projetoId = projetoId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ColaboradorProjetoId that = (ColaboradorProjetoId) o;
        return Objects.equals(colaboradorId, that.colaboradorId) &&
               Objects.equals(projetoId, that.projetoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(colaboradorId, projetoId);
    }
}
```

#### 2️⃣ Criando a Entidade `Colaborador`
```java
@Entity
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "colaborador", cascade = CascadeType.ALL)
    private List<ColaboradorProjeto> projetos;
}
```

#### 3️⃣ Criando a Entidade `Projeto`
```java
@Entity
public class Projeto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<ColaboradorProjeto> colaboradores;
}
```

#### 4️⃣ Criando a Entidade Intermediária `ColaboradorProjeto`
```java
@Entity
@IdClass(ColaboradorProjetoId.class)
public class ColaboradorProjeto {
    @Id
    private Long colaboradorId;

    @Id
    private Long projetoId;

    @ManyToOne
    @JoinColumn(name = "colaboradorId", insertable = false, updatable = false)
    private Colaborador colaborador;

    @ManyToOne
    @JoinColumn(name = "projetoId", insertable = false, updatable = false)
    private Projeto projeto;

    private String papel;
}
```

📌 **Explicação:**
- `@IdClass(ColaboradorProjetoId.class)` define a chave composta (`colaboradorId` e `projetoId`).
- `@Id` nos atributos `colaboradorId` e `projetoId` garante que eles fazem parte da PK.
- `@JoinColumn(name = "...", insertable = false, updatable = false)` evita a duplicação dos valores de FK.

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

Ficou claro? Qualquer dúvida, só perguntar! 😃

