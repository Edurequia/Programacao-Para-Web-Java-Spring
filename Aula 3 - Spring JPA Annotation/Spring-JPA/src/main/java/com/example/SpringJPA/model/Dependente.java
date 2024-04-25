package com.example.SpringJPA.model;

import jakarta.persistence.*;

import java.util.Date;

/**
 * Classe que representa a entidade Dependente.
 * Cada dependente está associado a um funcionário específico e contém informações pessoais,
 * incluindo o sexo, a data de nascimento e o parentesco com o funcionário.
 *
 * A relação entre Dependente e Funcionário é modelada usando uma chave primária composta
 * na classe DependenteId, com o identificador de Funcionário sendo uma parte essencial dessa chave.
 *
 * @Entity marca a classe como uma entidade gerenciável pela JPA.
 * @Table define o nome da tabela no banco de dados para esta entidade.
 */
@Entity
@Table(name = "DEPENDENTE")
public class Dependente {
    /**
     * Chave primária composta do dependente, definida na classe DependenteId.
     * @EmbeddedId é usada para incorporar a chave composta na entidade.
     */
    @EmbeddedId
    private DependenteId dependenteId;

    /**
     * Sexo do dependente, representado por um único caractere.
     */
    @Column(name ="Sexo")
    private char sexo;

    /**
     * Data de nascimento do dependente.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "Datanasc")
    private Date dataNasc;

    /**
     * Parentesco do dependente com o funcionário.
     */
    @Column(name = "Parentesco")
    private String parentesco;

    /**
     * O funcionário ao qual este dependente está associado.
     * A associação é feita pela chave primária do funcionário, que é parte da chave composta de DependenteId.
     *
     * @ManyToOne indica uma relação muitos-para-um com a entidade Funcionario.
     * @JoinColumn especifica a coluna que é usada para a chave estrangeira.
     * @MapsId é usada para indicar que a coluna da chave estrangeira é parte da chave primária composta.
     */
    @ManyToOne
    @JoinColumn(name = "Fcpf", nullable = false)
    @MapsId("funcionarioId")
    private Funcionario funcionario;
}
