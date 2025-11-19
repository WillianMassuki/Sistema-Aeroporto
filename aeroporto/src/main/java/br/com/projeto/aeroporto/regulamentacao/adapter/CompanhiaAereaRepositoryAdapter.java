package br.com.projeto.aeroporto.regulamentacao.adapter;


import br.com.projeto.aeroporto.regulamentacao.model.CompanhiaAerea;
import br.com.projeto.aeroporto.regulamentacao.out.CompanhiaAereaRepositoryPort;
import br.com.projeto.aeroporto.regulamentacao.repository.CompanhiaAereaRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class CompanhiaAereaRepositoryAdapter implements CompanhiaAereaRepositoryPort {

    private final CompanhiaAereaRepositoryJpa companhiaAereaRepositoryJpa;


    public CompanhiaAereaRepositoryAdapter(CompanhiaAereaRepositoryJpa companhiaAereaRepositoryJpa) {
        this.companhiaAereaRepositoryJpa = companhiaAereaRepositoryJpa;
    }

    @Override
    public CompanhiaAerea salvar(CompanhiaAerea companhiaAerea) {
        return companhiaAereaRepositoryJpa.save(companhiaAerea);
    }

    @Override
    public Optional<CompanhiaAerea> buscarPorId(Long id) {
        return companhiaAereaRepositoryJpa.findById(id);
    }

    @Override
    public List<CompanhiaAerea> buscarTodas() {
        return companhiaAereaRepositoryJpa.findAll();
    }

    @Override
    public void deletarPorId(Long id) {
        companhiaAereaRepositoryJpa.deleteById(id);

    }
}
