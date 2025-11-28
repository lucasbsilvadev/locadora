package com.locadora.service;

import com.locadora.model.Veiculo;
import com.locadora.repository.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository repository;

    public Veiculo salvar(Veiculo veiculo) {
        return repository.save(veiculo);
    }

    public List<Veiculo> listarTodos() {
        return repository.findAll();
    }

    public Veiculo buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado!"));
    }

    public Veiculo buscarPorPlaca(String placa) {
        return repository.findByPlaca(placa);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Veiculo atualizar(Long id, Veiculo v) {
        Veiculo veiculo = buscarPorId(id);

        veiculo.setMarca(v.getMarca());
        veiculo.setModelo(v.getModelo());
        veiculo.setAno(v.getAno());
        veiculo.setPlaca(v.getPlaca());
        veiculo.setCategoria(v.getCategoria());
        veiculo.setKm(v.getKm());
        veiculo.setStatus(v.getStatus());

        return repository.save(veiculo);
    }
}
