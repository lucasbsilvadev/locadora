package com.locadora.dto;

import java.time.LocalDate;

public class LocacaoResponseDTO {
    private Long id;
    private Long clienteId;
    private Long veiculoId;
    private LocalDate dataRetirada;
    private LocalDate dataPrevista;
    private LocalDate dataDevolucao;
    private String status;
    private String veiculoModelo;
    private String clienteNome;
}

