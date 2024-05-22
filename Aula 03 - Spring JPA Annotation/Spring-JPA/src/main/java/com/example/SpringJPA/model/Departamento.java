package com.example.SpringJPA.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

/**
 * Classe que representa a entidade Departamento no sistema. Cada departamento possui um número único,
 * um nome, uma data de início de gerência, uma lista de funcionários que trabalham no departamento,
 * um gerente, várias localizações onde o departamento opera, e uma lista de projetos associados.
 *
 * @Entity marca a classe como uma entidade JPA.
 * @Table define o nome da tabela no banco de dados para esta entidade.
 */
@Entity
@Table(name = "DEPARTAMENTO")
public class Departamento {
    /**
     * Número único do departamento, servindo como identificador primário.
     * @Id marca o campo como a chave primária.
     * @Column define propriedades da coluna no banco de dados.
     */
    @Id
    @Column(name = "Dnumero")
    private Long dNumero;

    /**
     * Nome do departamento, que é único e não pode ser nulo.
     */
    @Column(nullable = false, unique = true)
    private String nome;

    /**
     * Data de início do atual gerente no departamento.
     * @Temporal especifica que a precisão da data é apenas até o dia.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "Data_inicio_gerente")
    private Date dataInicioGerente;

    /**
     * Lista de funcionários que trabalham neste departamento.
     * @OneToMany indica uma relação um-para-muitos com a entidade Funcionario.
     */
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Funcionario> listaDeFuncionario;

    /**
     * Gerente do departamento.
     * @OneToOne indica uma relação um-para-um com a entidade Funcionario.
     */
    @OneToOne
    @JoinColumn(name = "gerente_id", nullable = false)
    private Funcionario gerente;

    /**
     * Localizações onde o departamento opera, representadas por uma lista de strings.
     * @ElementCollection é usada para definir uma coleção de elementos embutidos.
     * @CollectionTable define a tabela e coluna para persistir os elementos da coleção.
     */
    @ElementCollection
    @CollectionTable(
            name = "LOCALIZACAO_DEP",
            joinColumns = @JoinColumn(name = "Dnumero")
    )
    @Column(name = "Dlocal", nullable = false)
    private List<String> localizacoes;

    /**
     * Lista de projetos associados a este departamento.
     * @OneToMany indica uma relação um-para-muitos com a entidade Projeto.
     */
    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    List<Projeto> projetos;
}
