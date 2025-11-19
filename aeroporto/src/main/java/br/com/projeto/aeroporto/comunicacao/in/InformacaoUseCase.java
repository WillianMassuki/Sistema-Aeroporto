package br.com.projeto.aeroporto.comunicacao.in;


import br.com.projeto.aeroporto.comunicacao.model.Informacao;

import java.util.List;
import java.util.Optional;

/**
 * Caso de uso para gestão de {@link Informacao}.
 *
 * <p>
 * Define as operações da camada de aplicação relacionadas ao ciclo de vida
 * das informações: criação, busca, listagem, atualização e exclusão.
 * </p>
 *
 * <p>
 * As implementações desta interface normalmente concentram as regras de negócio
 * e orquestram o acesso à camada de persistência por meio de ports como
 * {@code InformacaoRepositoryPort}.
 * </p>
 */
public interface InformacaoUseCase {

    /**
     * Cria uma nova informação.
     *
     * @param informacao objeto contendo os dados da informação a ser criada
     * @return informação persistida
     */
    Informacao criar(Informacao informacao);

    /**
     * Busca uma informação pelo seu identificador.
     *
     * @param id identificador da informação
     * @return um {@link Optional} contendo a informação, caso encontrada;
     *         vazio caso não exista registro com o ID informado
     */
    Optional<Informacao> buscarPorId(String id);

    /**
     * Lista todas as informações cadastradas.
     *
     * @return lista de informações
     */
    List<Informacao> listar();

    /**
     * Atualiza os dados de uma informação existente.
     *
     * @param id         identificador da informação a ser atualizada
     * @param informacao objeto contendo os novos dados da informação
     * @return informação atualizada
     */
    Informacao atualizar(String id, Informacao informacao);

    /**
     * Remove uma informação com base em seu identificador.
     *
     * @param id identificador da informação a ser removida
     */
    void deletar(String id);
}