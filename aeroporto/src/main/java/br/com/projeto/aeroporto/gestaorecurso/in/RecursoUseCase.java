package br.com.projeto.aeroporto.gestaorecurso.in;


import br.com.projeto.aeroporto.gestaorecurso.model.Recurso;

import java.util.List;

public interface RecursoUseCase {

    Recurso criar(Recurso recurso);
    Recurso buscarPorId(String id);
    List<Recurso> listarTodos();
    void deletar(String id);
    Recurso alocar(String id);
    Recurso liberar(String id);
}
