package com.example.tprime.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "COMPRA")
public class Compra extends AbstractEntity<Long> {
    @Column(nullable = false)
    private float valorTotal;

    @Column(nullable = false)
    private LocalDate dataCompra;

    @Column(nullable = false)
    private String statusCompra;

    @OneToOne(mappedBy = "cliente")
    private Cliente cliente;

}
