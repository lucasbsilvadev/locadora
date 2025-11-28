package com.locadora.controller;

import com.locadora.dto.CriarLocacaoDTO;
import com.locadora.dto.FinalizarLocacaoDTO;
import com.locadora.model.Locacao;
import com.locadora.service.LocacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locacoes")
@RequiredArgsConstructor
public class LocacaoController {

    private final LocacaoService service;

    @PostMapping
    public Locacao criar(@RequestBody CriarLocacaoDTO dto) {
        return service.criarLocacao(
                dto.getClienteId(),
                dto.getVeiculoId(),
                dto.getDataRetirada(),
                dto.getDataPrevista(),
                dto.getStatus()
        );
    }

    @GetMapping
    public List<Locacao> listar() {
        return service.listarTodas();
    }

    @GetMapping("/{id}")
    public Locacao buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}/finalizar")
    public Locacao finalizar(
            @PathVariable Long id,
            @RequestBody FinalizarLocacaoDTO dto
    ) {
        return service.finalizarLocacao(
                id,
                dto.getDataDevolucao(),
                dto.getStatus()
        );
    }
}
