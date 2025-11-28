package com.locadora.repository;

import com.locadora.model.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    java.util.List<Locacao> findByClienteId(Long clienteId);

    java.util.List<Locacao> findByStatus(String status);
}
