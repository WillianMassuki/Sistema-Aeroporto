package br.com.projeto.aeroporto.gestao.in;


import br.com.projeto.aeroporto.gestao.model.Aeroporto;

import java.util.List;

/**
 * Caso de uso para gestão de {@link Aeroporto}.
 *
 * <p>
 * Define as operações da camada de aplicação relacionadas ao ciclo de vida
 * de aeroportos: criação, listagem, busca, atualização e exclusão.
 * </p>
 *
 * <p>
 * Implementações desta interface normalmente orquestram regras de negócio
 * e acessos ao repositório (por exemplo, via {@code AeroportoRepository}).
 * </p>
 */
public interface AeroportoUseCase {

    /**
     * Salva um novo aeroporto ou atualiza um já existente.
     *
     * @param aeroporto objeto contendo os dados do aeroporto a ser salvo
     * @return o aeroporto persistido, possivelmente com o ID preenchido
     */
    Aeroporto salvar(Aeroporto aeroporto);

    /**
     * Retorna a lista de todos os aeroportos cadastrados.
     *
     * @return lista de aeroportos
     */
    List<Aeroporto> listar();

    /**
     * Busca um aeroporto pelo seu identificador.
     *
     * @param id identificador do aeroporto
     * @return aeroporto correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o aeroporto não seja encontrado
     */
    Aeroporto buscarPorId(Long id);

    /**
     * Atualiza os dados de um aeroporto existente.
     *
     * @param id        identificador do aeroporto a ser atualizado
     * @param aeroporto objeto contendo os novos dados do aeroporto
     * @return aeroporto atualizado
     * @throws RuntimeException (ou exceção específica) caso o aeroporto não seja encontrado
     */
    Aeroporto atualizar(Long id, Aeroporto aeroporto);

    /**
     * Remove um aeroporto com base em seu identificador.
     *
     * @param id identificador do aeroporto a ser removido
     * @throws RuntimeException (ou exceção específica) caso o aeroporto não seja encontrado
     */
    void deletar(Long id);
}