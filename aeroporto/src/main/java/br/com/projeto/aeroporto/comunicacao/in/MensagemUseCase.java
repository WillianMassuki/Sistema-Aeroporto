package br.com.projeto.aeroporto.comunicacao.in;


import br.com.projeto.aeroporto.comunicacao.model.Mensagem;

import java.util.List;
import java.util.Optional;

/**
 * Caso de uso para gestão de {@link Mensagem}.
 *
 * <p>
 * Define as operações da camada de aplicação relacionadas ao ciclo de vida
 * das mensagens: criação, busca, listagem, atualização e exclusão.
 * </p>
 *
 * <p>
 * As implementações desta interface normalmente concentram as regras de negócio
 * e orquestram o acesso à camada de persistência por meio de ports como
 * {@code MensagemRepositoryPort}.
 * </p>
 */
public interface MensagemUseCase {

    /**
     * Cria uma nova mensagem.
     *
     * @param mensagem objeto contendo os dados da mensagem a ser criada
     * @return mensagem persistida
     */
    Mensagem criar(Mensagem mensagem);

    /**
     * Busca uma mensagem pelo seu identificador.
     *
     * @param id identificador da mensagem
     * @return um {@link Optional} contendo a mensagem, caso encontrada;
     *         vazio caso não exista registro com o ID informado
     */
    Optional<Mensagem> buscarPorId(String id);

    /**
     * Lista todas as mensagens cadastradas.
     *
     * @return lista de mensagens
     */
    List<Mensagem> listar();

    /**
     * Atualiza os dados de uma mensagem existente.
     *
     * @param id       identificador da mensagem a ser atualizada
     * @param mensagem objeto contendo os novos dados da mensagem
     * @return mensagem atualizada
     */
    Mensagem atualizar(String id, Mensagem mensagem);

    /**
     * Remove uma mensagem com base em seu identificador.
     *
     * @param id identificador da mensagem a ser removida
     */
    void deletar(String id);
}
