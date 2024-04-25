package com.example.SpringBackendCRUD.Model;

import com.example.SpringBackendCRUD.Model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import jakarta.persistence.*;

// Anotação indicando que esta classe é uma entidade JPA. Isso significa que objetos desta classe
// podem ser mapeados para registros de uma tabela de banco de dados.
@Entity

// Lombok annotations para gerar automaticamente os métodos getters e setters para todas as
// propriedades da classe, bem como um construtor padrão sem argumentos.
@Getter @Setter @NoArgsConstructor

// Definição da classe Phone, representando um telefone no contexto da aplicação.
public class Phone {

    // Identificador único para cada instância de Phone. Anotado para ser a chave primária na tabela de banco de dados.
    // A estratégia de geração é definida como IDENTITY, indicando que o valor será gerado pela coluna de identidade do banco de dados.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Propriedade 'type' para armazenar o tipo de telefone (ex: móvel, residencial, comercial).
    private String type;

    // Propriedade 'number' para armazenar o número do telefone.
    private String number;

    // Associação muitos-para-um entre Phone e User. Cada telefone está associado a um usuário.
    // A propriedade 'fetch' é definida como EAGER, o que significa que os dados do usuário associado serão carregados imediatamente.
    // A anotação @JoinColumn indica a coluna que faz a ligação (foreign key) na tabela de telefone para a tabela de usuário.
    // @JsonBackReference é usado para evitar referências circulares ao usar Jackson para serialização/deserialização JSON,
    // indicando que esta é a parte de trás da referência (o lado oposto de @JsonManagedReference).
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    // Construtor customizado criado com a anotação @Builder do Lombok, facilitando a criação de instâncias de Phone.
    // Permite a inicialização dos campos 'type', 'number', e 'user' diretamente, promovendo a imutabilidade onde possível.
    @Builder
    public Phone(String type, String number, User user) {
        this.type = type;
        this.number = number;
        this.user = user;
    }
}

