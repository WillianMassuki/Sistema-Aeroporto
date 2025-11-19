package br.com.projeto.aeroporto.gestaorecurso.out;

import br.com.projeto.aeroporto.gestaorecurso.model.Recurso;

import java.util.List;
import java.util.Optional;


public interface RecursoRepositoryPort {

    Recurso salvar(Recurso recurso);
    Optional<Recurso> buscarPorId(String id);
    List<Recurso> buscarTodos();
    void deletar(String id);
}
