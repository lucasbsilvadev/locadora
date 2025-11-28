package com.locadora.service;

import com.locadora.model.Cliente;
import com.locadora.model.Locacao;
import com.locadora.model.Veiculo;
import com.locadora.repository.LocacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LocacaoService {

    private final LocacaoRepository repository;
    private final ClienteService clienteService;
    private final VeiculoService veiculoService;

    public Locacao criarLocacao(Long clienteId, Long veiculoId, LocalDate retirada, LocalDate prevista, String status) {

        Cliente cliente = clienteService.buscarPorId(clienteId);
        Veiculo veiculo = veiculoService.buscarPorId(veiculoId);

        if (!veiculo.getStatus().equalsIgnoreCase("DISPONIVEL")) {
            throw new RuntimeException("Veículo não está disponível para locação.");
        }

        Locacao locacao = new Locacao();

        locacao.setCliente(cliente);
        locacao.setVeiculo(veiculo);
        locacao.setDataRetirada(retirada);
        locacao.setDataPrevista(prevista);
        locacao.setStatus(status);

        // muda o status do veículo
        veiculo.setStatus("ALUGADO");
        veiculoService.salvar(veiculo);

        return repository.save(locacao);
    }

    public Locacao finalizarLocacao(Long id, LocalDate dataDevolucao, String status) {
        Locacao locacao = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locação não encontrada!"));

        locacao.setDataDevolucao(dataDevolucao);
        locacao.setStatus(status);

        // libera veículo
        Veiculo veiculo = locacao.getVeiculo();
        veiculo.setStatus("DISPONIVEL");
        veiculoService.salvar(veiculo);

        return repository.save(locacao);
    }

    public List<Locacao> listarTodas() {
        return repository.findAll();
    }

    public Locacao buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Locação não encontrada!"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
