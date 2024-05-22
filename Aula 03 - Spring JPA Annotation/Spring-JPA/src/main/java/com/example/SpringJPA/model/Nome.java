package com.example.SpringJPA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

/**
 * Classe que representa a estrutura de nome de um funcionário.
 * Esta classe é usada como um tipo embutido na entidade Funcionario para
 * armazenar o nome completo de um funcionário dividido em primeiro nome, inicial do meio e último nome.
 *
 * @Embeddable indica que esta classe pode ser embutida em outras entidades.
 */
@Embeddable
public class Nome implements Serializable {

    // Primeiro nome do funcionário
    @Column(name = "Pnome")
    private String pNome;

    // Inicial do meio do funcionário
    @Column(name = "Minicial")
    private String mInicial;

    // Último nome do funcionário
    @Column(name = "Uname")
    private String uNome;

    // Getters e Setters omitidos para brevidade
}
