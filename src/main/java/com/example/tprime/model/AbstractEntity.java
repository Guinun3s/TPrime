package com.example.tprime.model;

import java.io.Serializable;


import jakarta.persistence.*;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper=false)
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable{
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;
    
}
