package com.api.protecaoanimal.models;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "castracao")
public class Castracao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    
    @Column(length = 36)
    private String idAnimal;

    @Column(length = 45)
    private String nome;

    @Column(length = 45)
    private String telefone;

    @Column(length = 45)
    private String email;

    @Column(length = 20)
    private String cpf;

    @Column(length = 20)
    private String rg;

    @Column(length = 100)
    private String rua;

    @Column()
    private int numero;

    @Column(length = 45)
    private String bairro;
    
    @Column(length = 45)
    private String complemento;
    
    @Column(length = 45)
    private String cidade;
    
    @Column(length = 45)
    private String estado;
    
    @Column(length = 15)
    private String cep;
    
}
