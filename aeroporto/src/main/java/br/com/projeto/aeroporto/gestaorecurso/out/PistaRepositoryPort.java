package br.com.projeto.aeroporto.gestaorecurso.out;


import br.com.projeto.aeroporto.gestaorecurso.model.Pista;

import java.util.List;
import java.util.Optional;

public interface PistaRepositoryPort {
    Pista salvar(Pista pista);
    Optional<Pista> buscarPorId(Long id);
    List<Pista> buscarTodas();
    void deletarPorId(Long id);
}