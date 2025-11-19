package br.com.projeto.aeroporto.gestaofinanceira.service;


import br.com.projeto.aeroporto.gestaofinanceira.in.FornecedorUseCase;
import br.com.projeto.aeroporto.gestaofinanceira.model.Fornecedor;
import br.com.projeto.aeroporto.gestaofinanceira.out.FornecedorRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorService implements FornecedorUseCase {

    private final FornecedorRepositoryPort repository;

    public FornecedorService(FornecedorRepositoryPort repository) {
        this.repository = repository;
    }

    public Fornecedor salvar(Fornecedor fornecedor) {
        return repository.salvar(fornecedor);
    }

    public List<Fornecedor> listar() {
        return repository.listar();
    }

    public Fornecedor buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));
    }

    public Fornecedor atualizar(Long id, Fornecedor novo) {
        Fornecedor atual = buscarPorId(id);
        atual.setNome(novo.getNome());
        atual.setServicoPrestado(novo.getServicoPrestado());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}