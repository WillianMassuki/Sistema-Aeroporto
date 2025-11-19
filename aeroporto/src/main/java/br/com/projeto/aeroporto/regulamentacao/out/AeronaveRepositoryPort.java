package br.com.projeto.aeroporto.regulamentacao.out;


import br.com.projeto.aeroporto.regulamentacao.model.Aeronave;

import java.util.List;
import java.util.Optional;

public interface AeronaveRepositoryPort {
    Aeronave salvar(Aeronave aeronave);
    Optional<Aeronave> buscarPorId(Long id);
    List<Aeronave> buscarTodas();
    void deletarPorId(Long id);
}
