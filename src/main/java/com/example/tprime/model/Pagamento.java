package com.example.tprime.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "PAGAMENTO")
public class Pagamento extends AbstractEntity<Long> {
    @Column(nullable = false)
    private LocalDate dataPagamento;
    
    @Column(nullable = false)
    private String formaPagamento;

}
