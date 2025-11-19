package br.com.projeto.aeroporto.gestaofinanceira.service;


import br.com.projeto.aeroporto.gestaofinanceira.in.DespesaUseCase;
import br.com.projeto.aeroporto.gestaofinanceira.model.Despesa;
import br.com.projeto.aeroporto.gestaofinanceira.out.DespesaRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService implements DespesaUseCase {

    private final DespesaRepositoryPort repository;

    public DespesaService(DespesaRepositoryPort repository) {
        this.repository = repository;
    }

    public Despesa salvar(Despesa despesa) {
        return repository.salvar(despesa);
    }

    public List<Despesa> listar() {
        return repository.listar();
    }

    public Despesa buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Despesa não encontrada"));
    }

    public Despesa atualizar(Long id, Despesa nova) {
        Despesa atual = buscarPorId(id);
        atual.setDescricao(nova.getDescricao());
        atual.setValor(nova.getValor());
        atual.setData(nova.getData());
        atual.setCategoria(nova.getCategoria());
        return repository.salvar(atual);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}