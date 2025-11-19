package br.com.projeto.aeroporto.comunicacao.out;


import br.com.projeto.aeroporto.comunicacao.model.Funcionario;

import java.util.List;
import java.util.Optional;

/**
 * Porta de saída (OutPort) para operações de persistência de {@link Funcionario}.
 *
 * <p>
 * Define o contrato da camada de aplicação com a infraestrutura de dados,
 * independente da tecnologia utilizada (JPA, JDBC, API externa etc.).
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface
 * representa a <b>porta de saída</b>, enquanto suas implementações concretas
 * (adapters) fazem a integração com o banco de dados ou outros sistemas.
 * </p>
 */
public interface FuncionarioRepositoryOutPort {

    /**
     * Salva um novo funcionário ou atualiza um já existente.
     *
     * @param funcionario objeto contendo os dados do funcionário a ser salvo
     * @return o funcionário persistido, possivelmente com o ID preenchido
     */
    Funcionario salvar(Funcionario funcionario);

    /**
     * Busca um funcionário pelo seu identificador.
     *
     * @param id identificador do funcionário
     * @return um {@link Optional} contendo o funcionário, caso encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<Funcionario> buscarPorId(Long id);

    /**
     * Busca todos os funcionários cadastrados.
     *
     * @return lista de funcionários
     */
    List<Funcionario> buscarTodos();

    /**
     * Remove um funcionário com base em seu identificador.
     *
     * @param id identificador do funcionário a ser removido
     */
    void deletarPorId(Long id);
}