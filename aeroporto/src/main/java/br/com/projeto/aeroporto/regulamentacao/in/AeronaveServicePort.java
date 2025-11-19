package br.com.projeto.aeroporto.regulamentacao.in;


import br.com.projeto.aeroporto.regulamentacao.model.Aeronave;

import java.util.List;
import java.util.Optional;

public interface AeronaveServicePort {
    Aeronave adicionarAeronava(Aeronave aeronave);
    Optional<Aeronave> buscarAeronavePorId(Long id);
    List<Aeronave> listarTodasAeronaves();
    Aeronave atualizarPista(Long id, Aeronave aeronave);
    void removerAeronave(Long id);
}
