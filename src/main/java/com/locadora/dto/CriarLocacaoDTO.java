package com.locadora.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CriarLocacaoDTO {
    private Long clienteId;
    private Long veiculoId;
    private LocalDate dataRetirada;
    private LocalDate dataPrevista;
    private String status;
}
