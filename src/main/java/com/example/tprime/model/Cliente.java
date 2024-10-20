package com.example.tprime.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "CLIENTE")
public class Cliente extends AbstractEntity<Long> {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate dataNas;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private LocalDate dataCads;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    private String endereco;

    @Column(nullable = false)
    private float divida;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_compra_fk")
    private Compra compra;

    @OneToMany(mappedBy = "cliente")
    private List<Produto> produtos;
    
}
