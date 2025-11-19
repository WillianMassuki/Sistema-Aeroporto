package br.com.projeto.aeroporto.gestao.in;


import br.com.projeto.aeroporto.gestao.model.Passageiro;

import java.util.List;

/**
 * Caso de uso para gestão de {@link Passageiro}.
 *
 * Define as operações da camada de aplicação relacionadas ao ciclo de vida
 * dos passageiros: criação, listagem, busca, atualização e exclusão.

 * As implementações desta interface normalmente contêm as regras de negócio
 * e orquestram o acesso à camada de persistência (por exemplo,
 * {@code PassageiroRepository}).
 */
public interface PassageiroUseCase {

    /**
     * Salva um novo passageiro ou atualiza um já existente.
     *
     * @param passageiro objeto contendo os dados do passageiro a ser salvo
     * @return o passageiro persistido, possivelmente com o ID preenchido
     */
    Passageiro salvar(Passageiro passageiro);

    /**
     * Retorna a lista de todos os passageiros cadastrados.
     *
     * @return lista de passageiros
     */
    List<Passageiro> listar();

    /**
     * Busca um passageiro pelo seu identificador.
     *
     * @param id identificador do passageiro
     * @return passageiro correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o passageiro não seja encontrado
     */
    Passageiro buscarPorId(Long id);

    /**
     * Atualiza os dados de um passageiro existente.
     *
     * @param id         identificador do passageiro a ser atualizado
     * @param passageiro objeto contendo os novos dados do passageiro
     * @return passageiro atualizado
     * @throws RuntimeException (ou exceção específica) caso o passageiro não seja encontrado
     */
    Passageiro atualizar(Long id, Passageiro passageiro);

    /**
     * Remove um passageiro com base em seu identificador.
     *
     * @param id identificador do passageiro a ser removido
     * @throws RuntimeException (ou exceção específica) caso o passageiro não seja encontrado
     */
    void deletar(Long id);

}