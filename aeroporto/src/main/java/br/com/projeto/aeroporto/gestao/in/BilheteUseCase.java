package br.com.projeto.aeroporto.gestao.in;


import br.com.projeto.aeroporto.gestao.model.Bilhete;

import java.util.List;

/**
 * Caso de uso para gestão de {@link Bilhete}.
 *
 * <p>
 * Define as operações da camada de aplicação relacionadas ao ciclo de vida
 * dos bilhetes: criação, listagem, busca, atualização e exclusão.
 * </p>
 *
 * <p>
 * Implementações desta interface normalmente concentram as regras de negócio
 * e a orquestração de acesso ao repositório de bilhetes (por exemplo,
 * {@code BilheteRepository}).
 * </p>
 */
public interface BilheteUseCase {

    /**
     * Salva um novo bilhete ou atualiza um já existente.
     *
     * @param bilhete objeto contendo os dados do bilhete a ser salvo
     * @return o bilhete persistido, possivelmente com o ID preenchido
     */
    Bilhete salvar(Bilhete bilhete);

    /**
     * Retorna a lista de todos os bilhetes cadastrados.
     *
     * @return lista de bilhetes
     */
    List<Bilhete> listar();

    /**
     * Busca um bilhete pelo seu identificador.
     *
     * @param id identificador do bilhete
     * @return bilhete correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o bilhete não seja encontrado
     */
    Bilhete buscarPorId(Long id);

    /**
     * Atualiza os dados de um bilhete existente.
     *
     * @param id      identificador do bilhete a ser atualizado
     * @param bilhete objeto contendo os novos dados do bilhete
     * @return bilhete atualizado
     * @throws RuntimeException (ou exceção específica) caso o bilhete não seja encontrado
     */
    Bilhete atualizar(Long id, Bilhete bilhete);

    /**
     * Remove um bilhete com base em seu identificador.
     *
     * @param id identificador do bilhete a ser removido
     * @throws RuntimeException (ou exceção específica) caso o bilhete não seja encontrado
     */
    void deletar(Long id);
}
