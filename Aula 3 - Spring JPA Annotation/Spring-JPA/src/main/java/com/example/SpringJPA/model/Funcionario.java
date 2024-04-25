package com.example.SpringJPA.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Representa um Funcionário dentro de um sistema organizacional. Esta entidade inclui informações pessoais,
 * financeiras e organizacionais de um funcionário, bem como relações com outras entidades como Departamento,
 * Dependente, e alocações de projeto.
 *
 * @Entity indica que esta classe é uma entidade JPA.
 * @Table define o nome da tabela no banco de dados para persistência.
 */
@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {
    /**
     * CPF do funcionário, servindo como identificador único dentro da tabela.
     * @Id marca o campo como a chave primária.
     * @Column define propriedades da coluna no banco de dados, como seu nome e tamanho.
     */
    @Id
    @Column(name="Cpf", length = 11)
    private String cpf;

    /**
     * Nome completo do funcionário, uma entidade incorporada que contém primeiro nome, inicial do meio e último nome.
     * @Embedded indica que os campos de Nome são incorporados diretamente na tabela de Funcionário.
     */
    @Embedded
    private Nome nome;

    /**
     * Data de nascimento do funcionário.
     * @Temporal especifica que a precisão da data é apenas até o dia.
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "Datanasc")
    private Date dataNasc;

    /**
     * Salário do funcionário representado por uma precisão decimal para lidar com valores financeiros.
     */
    @Column(name = "Salario")
    private BigDecimal salario;

    /**
     * Sexo do funcionário, representado por um único caractere (M/F).
     */
    @Column(name = "Sexo")
    private char sexo;

    /**
     * Endereço residencial do funcionário.
     */
    @Column(name = "Endereco")
    private String endereco;

    /**
     * Lista de dependentes associados a este funcionário. A relação é bidirecional.
     * @OneToMany indica uma relação um-para-muitos com a entidade Dependente.
     */
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Dependente> dependentes;

    /**
     * Departamento ao qual o funcionário está associado. A relação é muitos-para-um.
     * @ManyToOne indica uma relação muitos-para-um com a entidade Departamento.
     */
    @ManyToOne
    @JoinColumn(name = "Dnr", nullable = false)
    private Departamento departamento;

    /**
     * O departamento gerenciado pelo funcionário, se houver. Esta é uma relação um-para-um.
     * @OneToOne indica uma relação um-para-um com a entidade Departamento que o funcionário gerencia.
     */
    @OneToOne(mappedBy = "gerente")
    private Departamento dptGerenciado;

    /**
     * Supervisor direto do funcionário, formando uma hierarquia organizacional.
     * @ManyToOne indica uma relação muitos-para-um com outra instância de Funcionario.
     */
    @ManyToOne
    @JoinColumn(name = "Cpf_Supervisor")
    private Funcionario supervisor;

    /**
     * Lista de funcionários que são supervisionados por este funcionário.
     * @OneToMany indica uma relação um-para-muitos, representando a supervisão.
     */
    @OneToMany(mappedBy = "supervisor")
    private List<Funcionario> supervisionados;

    /**
     * Projetos e as respectivas horas trabalhadas por este funcionário. Isso permite armazenar mais informações além do relacionamento.
     * @OneToMany indica uma relação um-para-muitos com a entidade TrabalhaEm, que contém os detalhes das alocações.
     */
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<TrabalhaEm> alocacao;
}
