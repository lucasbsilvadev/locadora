package com.locadora.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "veiculos")
@Data
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String marca;
    private String modelo;
    private Integer ano;

    @Column(unique = true)
    private String placa;

    private String categoria;
    private Integer km;
    private String status;
}
