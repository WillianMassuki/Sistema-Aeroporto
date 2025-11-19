package br.com.projeto.aeroporto.comunicacao.out;


import br.com.projeto.aeroporto.comunicacao.model.Informacao;

import java.util.List;
import java.util.Optional;

/**
 * Porta de repositório para a entidade {@link Informacao}.
 *
 * <p>
 * Define o contrato da camada de aplicação com a camada de persistência
 * para operações relacionadas a {@code Informacao}, independente da
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
public interface InformacaoRepositoryPort {

    /**
     * Salva uma nova informação ou atualiza uma já existente.
     *
     * @param informacao objeto contendo os dados da informação a ser salva
     * @return a informação persistida
     */
    Informacao salvar(Informacao informacao);

    /**
     * Busca uma informação pelo seu identificador.
     *
     * @param id identificador da informação
     * @return um {@link Optional} contendo a informação, caso encontrada,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<Informacao> buscarPorId(String id);

    /**
     * Busca todas as informações cadastradas.
     *
     * @return lista de informações
     */
    List<Informacao> buscarTodos();

    /**
     * Remove uma informação com base em seu identificador.
     *
     * @param id identificador da informação a ser removida
     */
    void deletarPorId(String id);

}