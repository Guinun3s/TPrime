package com.example.tprime.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "COMPRA")
public class Compra extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private float valor;

    @Column(nullable = false)
    private LocalDate dataCompra;

    @ManyToOne
    @JoinColumn(name = "id_cliente_fk")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_produto_fk")
    private Produto produto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_compra_fk")
    private Pagamento pagamento;
}
