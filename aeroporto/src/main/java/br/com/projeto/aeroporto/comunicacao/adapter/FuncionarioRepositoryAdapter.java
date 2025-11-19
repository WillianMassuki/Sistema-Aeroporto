package br.com.projeto.aeroporto.comunicacao.adapter;


import br.com.projeto.aeroporto.comunicacao.model.Funcionario;
import br.com.projeto.aeroporto.comunicacao.out.FuncionarioRepositoryOutPort;
import br.com.projeto.aeroporto.comunicacao.repository.FuncionarioJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador de repositório para {@link Funcionario} utilizando JPA.
 *
 * <p>
 * Implementa a porta de saída {@link FuncionarioRepositoryOutPort} delegando
 * as operações de persistência ao {@link FuncionarioJpaRepository}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe atua como
 * <b>adapter de infraestrutura</b>, fazendo a ponte entre a camada de aplicação
 * (que conhece apenas a porta) e o banco de dados (via Spring Data JPA).
 * </p>
 */
@Component
public class FuncionarioRepositoryAdapter implements FuncionarioRepositoryOutPort {

    /**
     * Repositório JPA responsável pelo acesso direto aos dados de {@link Funcionario}.
     */
    private final FuncionarioJpaRepository jpaRepository;

    /**
     * Construtor com injeção de dependência do repositório JPA.
     *
     * @param jpaRepository implementação de {@link FuncionarioJpaRepository}
     *                      utilizada para persistir os dados de funcionários
     */
    public FuncionarioRepositoryAdapter(FuncionarioJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Salva um novo funcionário ou atualiza um já existente.
     *
     * <p>
     * Delegado ao método {@link FuncionarioJpaRepository#save(Object)}.
     * </p>
     *
     * @param funcionario funcionário a ser salvo
     * @return funcionário persistido
     */
    @Override
    public Funcionario salvar(Funcionario funcionario) {
        return jpaRepository.save(funcionario);
    }

    /**
     * Busca um funcionário pelo seu identificador.
     *
     * <p>
     * Delegado ao método {@link FuncionarioJpaRepository#findById(Object)}.
     * </p>
     *
     * @param id identificador do funcionário
     * @return um {@link Optional} contendo o funcionário, caso encontrado;
     *         vazio caso contrário
     */
    @Override
    public Optional<Funcionario> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    /**
     * Busca todos os funcionários cadastrados.
     *
     * <p>
     * Delegado ao método {@link FuncionarioJpaRepository#findAll()}.
     * </p>
     *
     * @return lista de funcionários
     */
    @Override
    public List<Funcionario> buscarTodos() {
        return jpaRepository.findAll();
    }

    /**
     * Remove um funcionário com base em seu identificador.
     *
     * <p>
     * Delegado ao método {@link FuncionarioJpaRepository#deleteById(Object)}.
     * </p>
     *
     * @param id identificador do funcionário a ser removido
     */
    @Override
    public void deletarPorId(Long id) {
        jpaRepository.deleteById(id);
    }
}
