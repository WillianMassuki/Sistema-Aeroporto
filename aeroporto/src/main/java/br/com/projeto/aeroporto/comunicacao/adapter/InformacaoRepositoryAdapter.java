package br.com.projeto.aeroporto.comunicacao.adapter;



import br.com.projeto.aeroporto.comunicacao.model.Informacao;
import br.com.projeto.aeroporto.comunicacao.out.InformacaoRepositoryPort;
import br.com.projeto.aeroporto.comunicacao.repository.InformacaoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de repositório para {@link Informacao} utilizando JPA.
 *
 * <p>
 * Implementa a porta {@link InformacaoRepositoryPort}, delegando as operações
 * de persistência ao {@link InformacaoJpaRepository} do Spring Data JPA.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe atua como
 * <b>adapter de infraestrutura</b>, fazendo a ponte entre a camada de aplicação
 * (que conhece apenas a porta) e o banco de dados.
 * </p>
 */
@Component
public class InformacaoRepositoryAdapter implements InformacaoRepositoryPort {

    /**
     * Repositório JPA responsável pelo acesso direto aos dados de {@link Informacao}.
     */
    private final InformacaoJpaRepository jpaRepository;

    /**
     * Construtor com injeção de dependência do repositório JPA.
     *
     * @param jpaRepository implementação de {@link InformacaoJpaRepository}
     *                      utilizada para persistir as informações
     */
    public InformacaoRepositoryAdapter(InformacaoJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Salva uma nova informação ou atualiza uma já existente.
     *
     * <p>
     * Delegado ao método {@link InformacaoJpaRepository#save(Object)}.
     * </p>
     *
     * @param informacao entidade a ser salva
     * @return informação persistida
     */
    @Override
    public Informacao salvar(Informacao informacao) {
        return jpaRepository.save(informacao);
    }

    /**
     * Busca uma informação pelo seu identificador.
     *
     * <p>
     * Delegado ao método {@link InformacaoJpaRepository#findById(Object)}.
     * </p>
     *
     * @param id identificador da informação
     * @return um {@link Optional} contendo a informação, caso encontrada;
     *         vazio caso contrário
     */
    @Override
    public Optional<Informacao> buscarPorId(String id) {
        return jpaRepository.findById(id);
    }

    /**
     * Busca todas as informações cadastradas.
     *
     * <p>
     * Delegado ao método {@link InformacaoJpaRepository#findAll()}.
     * </p>
     *
     * @return lista de informações
     */
    @Override
    public List<Informacao> buscarTodos() {
        return jpaRepository.findAll();
    }

    /**
     * Remove uma informação com base em seu identificador.
     *
     * <p>
     * Delegado ao método {@link InformacaoJpaRepository#deleteById(Object)}.
     * </p>
     *
     * @param id identificador da informação a ser removida
     */
    @Override
    public void deletarPorId(String id) {
        jpaRepository.deleteById(id);
    }
}