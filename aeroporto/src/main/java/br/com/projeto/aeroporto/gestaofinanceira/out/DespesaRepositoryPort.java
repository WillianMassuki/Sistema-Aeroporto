package br.com.projeto.aeroporto.gestaofinanceira.out;


import br.com.projeto.aeroporto.gestaofinanceira.model.Despesa;

import java.util.List;
import java.util.Optional;

public interface DespesaRepositoryPort {
    Despesa salvar(Despesa despesa);
    List<Despesa> listar();
    Optional<Despesa> buscarPorId(Long id);
    void deletar(Long id);
}

