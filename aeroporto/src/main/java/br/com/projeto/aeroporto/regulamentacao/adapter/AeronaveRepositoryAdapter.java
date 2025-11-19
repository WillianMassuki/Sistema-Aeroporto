package br.com.projeto.aeroporto.regulamentacao.adapter;


import br.com.projeto.aeroporto.regulamentacao.model.Aeronave;
import br.com.projeto.aeroporto.regulamentacao.out.AeronaveRepositoryPort;
import br.com.projeto.aeroporto.regulamentacao.repository.AeronaveRepositoryJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AeronaveRepositoryAdapter implements AeronaveRepositoryPort {

    private final AeronaveRepositoryJpa repositoryJpa;


    public AeronaveRepositoryAdapter(AeronaveRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

/*
    private Pista toDomain(Aeronave entity) {
        return new Pista(entity.getCodigoAeronave(), entity.getStatusCertificacao());
    }

 */

    @Override
    public Aeronave salvar(Aeronave aeronave) {
        return null;
    }

    @Override
    public Optional<Aeronave> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Aeronave> buscarTodas() {
        return List.of();
    }

    @Override
    public void deletarPorId(Long id) {

    }
}
