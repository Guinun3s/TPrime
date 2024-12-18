package com.example.tprime.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "PRODUTO")
public class Produto extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private float valor;

    //Relacionamento
    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Compra> compras = new ArrayList<>();

    //toString para exibir as informações do produto
    @Override
    public String toString() {
        return "\nProduto id= " + id + "\nnome= " + nome + "\nvalor= " + valor + "\n";
    }
}
