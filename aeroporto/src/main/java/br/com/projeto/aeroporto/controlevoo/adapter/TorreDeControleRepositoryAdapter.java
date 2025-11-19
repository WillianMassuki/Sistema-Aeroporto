package br.com.project.airport.controlevoo.adapter;


import br.com.projeto.aeroporto.controlevoo.model.TorreDeControle;
import br.com.projeto.aeroporto.controlevoo.repository.TorreDeControleJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adapter responsável por encapsular o acesso ao repositório JPA
 * {@link TorreDeControleJpaRepository} para a entidade {@link TorreDeControle}.
 *
 * <p>
 * Esta classe centraliza as operações de persistência relacionadas à
 * {@code TorreDeControle}, servindo como uma camada intermediária entre
 * a lógica de negócio e o repositório JPA.
 * </p>
 */
@Component
public class TorreDeControleRepositoryAdapter {

    private final TorreDeControleJpaRepository repository;

    /**
     * Construtor da classe {@code TorreDeControleRepositoryAdapter}.
     *
     * @param repository repositório JPA responsável pelo acesso aos dados
     *                   da entidade {@link TorreDeControle}
     */
    public TorreDeControleRepositoryAdapter(TorreDeControleJpaRepository repository) {
        this.repository = repository;
    }

    /**
     * Cria ou atualiza uma torre de controle no banco de dados.
     *
     * @param torre objeto {@link TorreDeControle} a ser salvo
     * @return a instância de {@link TorreDeControle} salva, possivelmente com ID gerado/atualizado
     */
    public TorreDeControle criarTorre(TorreDeControle torre) {
        return repository.save(torre);
    }

    /**
     * Busca uma torre de controle pelo seu identificador.
     *
     * @param id identificador único da torre de controle
     * @return um {@link Optional} contendo a {@link TorreDeControle}, caso encontrada,
     *         ou vazio se não houver registro com o ID informado
     */
    public Optional<TorreDeControle> buscarPorId(Long id) {
        return repository.findById(id);
    }

    /**
     * Lista todas as torres de controle cadastradas no banco de dados.
     *
     * @return lista contendo todas as instâncias de {@link TorreDeControle} persistidas
     */
    public List<TorreDeControle> listarTodas() {
        return repository.findAll();
    }

    /**
     * Remove uma torre de controle do banco de dados com base no seu identificador.
     *
     * @param id identificador da torre de controle a ser removida
     */
    public void deletarPorId(Long id) {
        repository.deleteById(id);
    }
}