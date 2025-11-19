package br.com.projeto.aeroporto.comunicacao.adapter;


import br.com.projeto.aeroporto.comunicacao.model.Mensagem;
import br.com.projeto.aeroporto.comunicacao.out.MensagemRepositoryPort;
import br.com.projeto.aeroporto.comunicacao.repository.MensagemJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de repositório para {@link Mensagem} utilizando JPA.
 *
 * <p>
 * Implementa a porta {@link MensagemRepositoryPort}, delegando as operações
 * de persistência ao {@link MensagemJpaRepository} do Spring Data JPA.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe atua como
 * um <b>adapter de infraestrutura</b>, fazendo a ponte entre a camada de
 * aplicação (que conhece apenas a porta) e o banco de dados.
 * </p>
 */
@Component
public class MensagemRepositoryAdapter implements MensagemRepositoryPort {

    /**
     * Repositório JPA responsável pelo acesso direto aos dados de {@link Mensagem}.
     */
    private final MensagemJpaRepository jpaRepository;

    /**
     * Construtor com injeção de dependência do repositório JPA.
     *
     * @param jpaRepository implementação de {@link MensagemJpaRepository}
     *                      utilizada para persistir as mensagens
     */
    public MensagemRepositoryAdapter(MensagemJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Salva uma nova mensagem ou atualiza uma já existente.
     *
     * <p>
     * Delegado ao método {@link MensagemJpaRepository#save(Object)}.
     * </p>
     *
     * @param mensagem entidade a ser salva
     * @return mensagem persistida
     */
    @Override
    public Mensagem salvar(Mensagem mensagem) {
        return jpaRepository.save(mensagem);
    }

    /**
     * Busca uma mensagem pelo seu identificador.
     *
     * <p>
     * Delegado ao método {@link MensagemJpaRepository#findById(Object)}.
     * </p>
     *
     * @param id identificador da mensagem
     * @return um {@link Optional} contendo a mensagem, caso encontrada;
     *         vazio caso contrário
     */
    @Override
    public Optional<Mensagem> buscarPorId(String id) {
        return jpaRepository.findById(id);
    }

    /**
     * Busca todas as mensagens cadastradas.
     *
     * <p>
     * Delegado ao método {@link MensagemJpaRepository#findAll()}.
     * </p>
     *
     * @return lista de mensagens
     */
    @Override
    public List<Mensagem> buscarTodos() {
        return jpaRepository.findAll();
    }

    /**
     * Remove uma mensagem com base em seu identificador.
     *
     * <p>
     * Delegado ao método {@link MensagemJpaRepository#deleteById(Object)}.
     * </p>
     *
     * @param id identificador da mensagem a ser removida
     */
    @Override
    public void deletarPorId(String id) {
        jpaRepository.deleteById(id);
    }
}