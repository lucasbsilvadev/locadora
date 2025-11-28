package com.locadora.service;

import com.locadora.model.Usuario;
import com.locadora.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository repository;

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Usuario buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    public Usuario atualizar(Long id, Usuario u) {
        Usuario usuario = buscarPorId(id);

        usuario.setNome(u.getNome());
        usuario.setEmail(u.getEmail());
        usuario.setSenha(u.getSenha());
        usuario.setRole(u.getRole());

        return repository.save(usuario);
    }
}
