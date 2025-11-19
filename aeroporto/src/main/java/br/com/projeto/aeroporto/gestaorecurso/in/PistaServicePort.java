package br.com.projeto.aeroporto.gestaorecurso.in;


import br.com.projeto.aeroporto.gestaorecurso.model.Pista;

import java.util.List;
import java.util.Optional;

public interface PistaServicePort {
    Pista criarPista(Pista pista);
    Optional<Pista> buscarPorId(Long id);
    List<Pista> listarTodas();
    Pista atualizarPista(Long id, Pista pista);
    void deletarPista(Long id);
}