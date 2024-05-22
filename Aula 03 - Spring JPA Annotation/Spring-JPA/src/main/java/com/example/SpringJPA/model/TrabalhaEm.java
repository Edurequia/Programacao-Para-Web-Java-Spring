package com.example.SpringJPA.model;

import jakarta.persistence.*;

/**
 * Classe que modela a relação de alocação de funcionários em projetos, permitindo registrar o número de horas
 * que cada funcionário dedica a um projeto específico. Esta entidade serve como uma tabela de associação
 * entre Funcionario e Projeto, com a adição do campo 'horas' para detalhar a extensão do envolvimento do funcionário.
 *
 * @Entity marca a classe como uma entidade JPA.
 * @Table define o nome da tabela no banco de dados para esta entidade.
 */
@Entity
@Table(name = "TRABALHA_EM")
public class TrabalhaEm {
    /**
     * Identificador composto da alocação, representando a combinação única de um funcionário e um projeto.
     * @EmbeddedId é usado para indicar que o identificador é uma chave composta, definida em outra classe.
     */
    @EmbeddedId
    private TrabalhaEmId id;

    /**
     * Número de horas que o funcionário está alocado para trabalhar no projeto. Este campo adiciona
     * uma dimensão quantitativa à relação entre funcionário e projeto.
     */
    private int horas;

    /**
     * Funcionário associado a esta alocação. Este lado da relação mapeia o funcionárioId parte da chave composta
     * à entidade Funcionario, estabelecendo a conexão entre a alocação e o funcionário específico.
     *
     * @ManyToOne indica uma relação muitos-para-um com a entidade Funcionario.
     * @MapsId é utilizado para mapear o atributo funcionarioId da chave composta ao Funcionario correspondente.
     * @JoinColumn especifica a coluna no banco de dados que é usada como chave estrangeira.
     */
    @ManyToOne
    @MapsId("funcionarioId")
    @JoinColumn(name = "Fcpf", nullable = false)
    private Funcionario funcionario;

    /**
     * Projeto associado a esta alocação. Este lado da relação mapeia o projetoId parte da chave composta
     * à entidade Projeto, estabelecendo a conexão entre a alocação e o projeto específico.
     *
     * @ManyToOne indica uma relação muitos-para-um com a entidade Projeto.
     * @MapsId é utilizado para mapear o atributo projetoId da chave composta ao Projeto correspondente.
     * @JoinColumn especifica a coluna no banco de dados que é usada como chave estrangeira.
     */
    @ManyToOne
    @MapsId("projetoId")
    @JoinColumn(name = "Pnr", nullable = false)
    private Projeto projeto;

    // Implementações de getters e setters, bem como os métodos equals(), hashCode() e toString() devem ser incluídos aqui.
}
