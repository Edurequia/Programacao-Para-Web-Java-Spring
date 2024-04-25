package com.example.SpringJPA.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Representa um projeto dentro da organização. Cada projeto é identificado por um número único,
 * tem um nome, é conduzido em um local específico, e está associado a um departamento.
 *
 * A classe também define a relação entre projetos e funcionários, indicando quais funcionários
 * estão alocados para trabalhar em cada projeto, bem como suas respectivas horas trabalhadas,
 * através de uma relação com a entidade TrabalhaEm.
 *
 * @Entity marca a classe como uma entidade JPA.
 * @Table define o nome da tabela no banco de dados para esta entidade.
 */
@Entity
@Table(name = "PROJETO")
public class Projeto {
    /**
     * Número do projeto, atuando como identificador único.
     * @Id marca o campo como a chave primária.
     * @Column indica que o valor é único dentro da tabela.
     */
    @Id
    @Column(name = "Pnumero", unique = true)
    private Long numero;

    /**
     * Nome do projeto.
     */
    @Column(name = "Projnome")
    private String nome;

    /**
     * Local onde o projeto é realizado.
     */
    @Column(name = "Projlocal")
    private String local;

    /**
     * Lista de alocações que representa os funcionários alocados para este projeto e as horas trabalhadas.
     * @OneToMany indica uma relação um-para-muitos com a entidade TrabalhaEm.
     */
    @OneToMany(mappedBy = "projeto", cascade = CascadeType.ALL)
    private List<TrabalhaEm> alocacao;

    /**
     * Departamento ao qual o projeto está associado.
     * @ManyToOne indica uma relação muitos-para-um com a entidade Departamento.
     */
    @ManyToOne
    @JoinColumn(name = "Dnum", nullable = false)
    private Departamento departamento;
}
