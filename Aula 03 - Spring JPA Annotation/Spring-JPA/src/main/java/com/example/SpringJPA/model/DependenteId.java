package com.example.SpringJPA.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class DependenteId implements Serializable {
    @Column(name = "Fcpf")
    private String funcionarioId;
    @Column (name = "Nome_dependente")
    private String nome;
}
