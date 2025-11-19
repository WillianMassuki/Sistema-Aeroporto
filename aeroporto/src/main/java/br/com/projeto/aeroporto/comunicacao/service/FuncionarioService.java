package br.com.projeto.aeroporto.comunicacao.service;


import br.com.projeto.aeroporto.comunicacao.in.FuncionarioUseCase;
import br.com.projeto.aeroporto.comunicacao.model.Funcionario;
import br.com.projeto.aeroporto.comunicacao.out.FuncionarioRepositoryOutPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço de aplicação para operações relacionadas a {@link Funcionario}.
 *
 * <p>
 * Implementa o caso de uso {@link FuncionarioUseCase}, centralizando as regras
 * de negócio e delegando o acesso a dados para a porta de saída
 * {@link FuncionarioRepositoryOutPort}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe pertence
 * à camada de aplicação e normalmente é utilizada por controladores REST
 * ou outros componentes de interface.
 * </p>
 */
@Service
public class FuncionarioService implements FuncionarioUseCase {

    /**
     * Porta de saída responsável pelo acesso aos dados de {@link Funcionario}.
     */
    private final FuncionarioRepositoryOutPort repository;

    /**
     * Construtor com injeção de dependência do repositório (porta de saída).
     *
     * @param repository implementação de {@link FuncionarioRepositoryOutPort}
     *                   usada para persistência dos dados de funcionários
     */
    public FuncionarioService(FuncionarioRepositoryOutPort repository) {
        this.repository = repository;
    }

    /**
     * Cria um novo funcionário.
     *
     * <p>
     * Delegado ao método {@link FuncionarioRepositoryOutPort#salvar(Funcionario)}.
     * </p>
     *
     * @param funcionario objeto contendo os dados do funcionário a ser criado
     * @return funcionário persistido (normalmente com ID preenchido)
     */
    @Override
    public Funcionario criar(Funcionario funcionario) {
        return repository.salvar(funcionario);
    }

    /**
     * Busca um funcionário pelo seu identificador.
     *
     * @param id identificador do funcionário
     * @return um {@link Optional} contendo o funcionário, caso encontrado;
     *         vazio caso contrário
     */
    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    /**
     * Lista todos os funcionários cadastrados.
     *
     * @return lista de funcionários
     */
    @Override
    public List<Funcionario> listar() {
        return repository.buscarTodos();
    }

    /**
     * Atualiza os dados de um funcionário existente.
     *
     * <p>
     * Primeiro busca o funcionário pelo ID; se existir, atualiza seus campos
     * (nome, cargo e matrícula) e o persiste novamente. Caso não seja encontrado,
     * lança uma {@link RuntimeException}.
     * </p>
     *
     * @param id          identificador do funcionário a ser atualizado
     * @param funcionario objeto contendo os novos dados do funcionário
     * @return funcionário atualizado e persistido
     * @throws RuntimeException caso o funcionário não seja encontrado
     */
    @Override
    public Funcionario atualizar(Long id, Funcionario funcionario) {
        Optional<Funcionario> existente = repository.buscarPorId(id);
        if (existente.isPresent()) {
            Funcionario atualizado = existente.get();
            atualizado.setNome(funcionario.getNome());
            atualizado.setCargo(funcionario.getCargo());
            atualizado.setMatricula(funcionario.getMatricula());
            return repository.salvar(atualizado);
        } else {
            throw new RuntimeException("Funcionario não encontrado");
        }
    }

    /**
     * Remove um funcionário com base em seu identificador.
     *
     * @param id identificador do funcionário a ser removido
     */
    @Override
    public void deletar(Long id) {
        repository.deletarPorId(id);
    }

}