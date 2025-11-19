package br.com.projeto.aeroporto.comunicacao.in;


import br.com.projeto.aeroporto.comunicacao.model.Funcionario;

import java.util.List;
import java.util.Optional;

/**
 * Caso de uso para gestão de {@link Funcionario}.
 *
 * <p>
 * Define as operações da camada de aplicação relacionadas ao ciclo de vida
 * dos funcionários: criação, busca, listagem, atualização e exclusão.
 * </p>
 *
 * <p>
 * As implementações desta interface normalmente concentram as regras de negócio
 * e orquestram o acesso à camada de persistência (por meio de ports como
 * {@code FuncionarioRepositoryOutPort}).
 * </p>
 */
public interface FuncionarioUseCase {

    /**
     * Cria um novo funcionário.
     *
     * @param funcionario objeto contendo os dados do funcionário a ser criado
     * @return funcionário persistido (normalmente com ID preenchido)
     */
    Funcionario criar(Funcionario funcionario);

    /**
     * Busca um funcionário pelo seu identificador.
     *
     * @param id identificador do funcionário
     * @return um {@link Optional} contendo o funcionário, caso encontrado;
     *         vazio caso não exista registro com o ID informado
     */
    Optional<Funcionario> buscarPorId(Long id);

    /**
     * Lista todos os funcionários cadastrados.
     *
     * @return lista de funcionários
     */
    List<Funcionario> listar();

    /**
     * Atualiza os dados de um funcionário existente.
     *
     * @param id          identificador do funcionário a ser atualizado
     * @param funcionario objeto contendo os novos dados do funcionário
     * @return funcionário atualizado
     */
    Funcionario atualizar(Long id, Funcionario funcionario);

    /**
     * Remove um funcionário com base em seu identificador.
     *
     * @param id identificador do funcionário a ser removido
     */
    void deletar(Long id);
}