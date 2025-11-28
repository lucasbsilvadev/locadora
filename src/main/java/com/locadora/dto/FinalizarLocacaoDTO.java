package com.locadora.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class FinalizarLocacaoDTO {
    private LocalDate dataDevolucao;
    private String status;
}
