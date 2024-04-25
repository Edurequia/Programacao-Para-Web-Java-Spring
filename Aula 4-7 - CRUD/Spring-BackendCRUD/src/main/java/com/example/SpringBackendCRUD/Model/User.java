package com.example.SpringBackendCRUD.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.List;

// Anotação que marca a classe como uma entidade JPA, o que significa que objetos dessa classe
// são capazes de serem persistidos no banco de dados.
@Entity

// Anotações do Lombok que geram automaticamente os métodos getters e setters para as propriedades da classe,
// bem como um construtor padrão sem argumentos. Isso ajuda a reduzir o boilerplate code.
@Getter @Setter @NoArgsConstructor

// Define a classe User, representando um usuário na aplicação.
public class User {

    // Anotação que marca este campo como a chave primária da entidade. O valor é gerado automaticamente
    // pelo banco de dados usando a estratégia IDENTITY, que suporta a geração de IDs únicos.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Propriedade para armazenar o nome do usuário.
    private String name;

    // Propriedade para armazenar o email do usuário. Este campo pode ser usado para login ou notificações.
    private String email;

    // Define uma relação Um-para-Muitos com a entidade Phone. Ou seja, um usuário pode ter vários telefones.
    // A propriedade 'mappedBy' indica que a entidade Phone possui uma propriedade chamada 'user' que é a chave estrangeira.
    // A anotação 'cascade = CascadeType.ALL' indica que as operações de persistência aplicadas ao usuário são propagadas para os telefones.
    // A propriedade 'fetch = FetchType.EAGER' garante que a lista de telefones seja carregada imediatamente com o usuário.
    // @JsonManagedReference é usada para lidar corretamente com referências circulares durante a serialização JSON.
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Phone> phones;

    // Construtor personalizado que permite a criação de um objeto User com nome, email e uma lista de telefones.
    // Este construtor é especialmente útil para a criação de instâncias de User de maneira fluente e imutável,
    // facilitando o preenchimento dos dados em cenários como carregamento de dados de teste ou criação de usuários em batch.
    @Builder
    public User(String name, String email, List<Phone> phones) {
        this.name = name;
        this.email = email;
        this.phones = phones;
    }
}

