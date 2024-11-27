package com.example.tprime.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name = "PAGAMENTO")
public class Pagamento extends AbstractEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate dataPagamento;
    
    @Column(nullable = false)
    private String formaPagamento;

    @OneToOne(mappedBy = "pagamento")
    private Compra compra;
    
}
