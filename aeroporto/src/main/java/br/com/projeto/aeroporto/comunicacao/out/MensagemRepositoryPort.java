package br.com.projeto.aeroporto.comunicacao.out;


import br.com.projeto.aeroporto.comunicacao.model.Mensagem;

import java.util.List;
import java.util.Optional;

/**
 * Porta de repositório para a entidade {@link Mensagem}.
 *
 * <p>
 * Define o contrato da camada de aplicação com a camada de persistência
 * para operações relacionadas a {@code Mensagem}, independente da
 * tecnologia utilizada (JPA, JDBC, API externa etc.).
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface
 * representa uma <b>porta</b>, enquanto as implementações concretas
 * são os <b>adapters</b> responsáveis por acessar o banco de dados
 * ou outros sistemas.
 * </p>
 */
public interface MensagemRepositoryPort {

    /**
     * Salva uma nova mensagem ou atualiza uma já existente.
     *
     * @param mensagem objeto contendo os dados da mensagem a ser salva
     * @return a mensagem persistida
     */
    Mensagem salvar(Mensagem mensagem);

    /**
     * Busca uma mensagem pelo seu identificador.
     *
     * @param id identificador da mensagem
     * @return um {@link Optional} contendo a mensagem, caso encontrada,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<Mensagem> buscarPorId(String id);

    /**
     * Busca todas as mensagens cadastradas.
     *
     * @return lista de mensagens
     */
    List<Mensagem> buscarTodos();

    /**
     * Remove uma mensagem com base em seu identificador.
     *
     * @param id identificador da mensagem a ser removida
     */
    void deletarPorId(String id);
}