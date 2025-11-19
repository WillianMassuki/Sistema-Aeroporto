package br.com.projeto.aeroporto.regulamentacao.service;


import br.com.projeto.aeroporto.regulamentacao.in.CompanhiaAereaServicePort;
import br.com.projeto.aeroporto.regulamentacao.model.CompanhiaAerea;
import br.com.projeto.aeroporto.regulamentacao.repository.CompanhiaAereaRepositoryJpa;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanhiaAereaService implements CompanhiaAereaServicePort {

    private final CompanhiaAereaRepositoryJpa companhiaAereaRepositoryJpa;

    public CompanhiaAereaService(CompanhiaAereaRepositoryJpa companhiaAereaRepositoryJpa) {
        this.companhiaAereaRepositoryJpa = companhiaAereaRepositoryJpa;
    }


    @Override
    public CompanhiaAerea criarCompanhiaAerea(CompanhiaAerea companhiaAerea) {
        return companhiaAereaRepositoryJpa.save(companhiaAerea);
    }

    @Override
    public Optional<CompanhiaAerea> buscarPorId(Long id) {
        return companhiaAereaRepositoryJpa.findById(id);
    }

    @Override
    public List<CompanhiaAerea> listarTodasCompanhias() {
        return companhiaAereaRepositoryJpa.findAll();
    }

    @Override
    public CompanhiaAerea atualizarCompanhiaAerea(Long id, CompanhiaAerea companhiaAerea) {
        return null;
    }


    @Override
    public void deletarCompanhia(Long id) {
        companhiaAereaRepositoryJpa.deleteById(id);

    }
}

   /*
    @Override
    public CompanhiaAerea atualizarCompanhiaAerea(Long id, CompanhiaAerea companhiaAerea) {
        return companhiaAereaRepositoryJpa.
    }

     */