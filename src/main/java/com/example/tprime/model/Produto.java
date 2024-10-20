package com.example.tprime.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractEntity<Long> {
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private String categoria;

    @Column(nullable = false)
    private int estoque;

    @Column(nullable = false)
    private String descricao;

    @ManyToOne
    @JoinColumn(name= "id_cliente_fk")
    private Cliente cliente;

}
