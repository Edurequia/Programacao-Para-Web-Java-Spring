package com.example.SpringJPA.model;

import jakarta.persistence.*;
import java.io.Serializable;

/**
 * Classe que define a chave composta para a entidade TrabalhaEm. Esta chave é usada para identificar
 * de forma única as alocações de funcionários em projetos, combinando o identificador do funcionário
 * com o identificador do projeto.
 *
 * @Embeddable marca esta classe como incorporável, o que significa que seus campos serão parte
 * da tabela da entidade que utiliza esta chave composta.
 */
@Embeddable
public class TrabalhaEmId implements Serializable {
    /**
     * Identificador do funcionário, parte da chave composta. Corresponde ao CPF do funcionário.
     *
     * @Column anotação define a coluna correspondente na tabela do banco de dados.
     */
    @Column(name = "Fcpf")
    private String funcionarioId;

    /**
     * Identificador do projeto, parte da chave composta.
     *
     * @Column anotação define a coluna correspondente na tabela do banco de dados.
     */
    @Column(name = "Pnr")
    private Long projetoId;

    // Getters e Setters para funcionarioId e projetoId

    /**
     * Implementa equals e hashCode para garantir a unicidade e comparabilidade das instâncias
     * de chave composta. Estes métodos são essenciais para o correto funcionamento da chave
     * primária composta em JPA.
     */

    // Omissão dos métodos equals, hashCode e possíveis getters/setters para brevidade.
}
