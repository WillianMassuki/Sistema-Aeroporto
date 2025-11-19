package br.com.projeto.aeroporto.regulamentacao.in;


import br.com.projeto.aeroporto.gestaorecurso.model.Pista;
import br.com.projeto.aeroporto.regulamentacao.model.Norma;

import java.util.List;
import java.util.Optional;

public interface NormaServicePort {
    Norma criarNorma(Norma norma);
    Optional<Norma> buscarPorId(Long id);
    List<Norma> listarTodasNorma();
    Pista atualizarNorma(Long id, Norma norma);
    void deletarNorma(Long id);
}
