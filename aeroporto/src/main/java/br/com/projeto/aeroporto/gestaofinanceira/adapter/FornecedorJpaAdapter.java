package br.com.projeto.aeroporto.gestaofinanceira.adapter;


import br.com.projeto.aeroporto.gestaofinanceira.model.Fornecedor;
import br.com.projeto.aeroporto.gestaofinanceira.out.FornecedorRepositoryPort;
import br.com.projeto.aeroporto.gestaofinanceira.repository.FornecedorJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adapter responsável por implementar a porta {@link FornecedorRepositoryPort}
 * utilizando o repositório JPA {@link FornecedorJpaRepository}.
 *
 * <p>
 * Esta classe faz a ponte entre a camada de domínio e a camada de persistência,
 * seguindo o padrão de arquitetura Hexagonal (Ports and Adapters).
 * O domínio conhece apenas a interface ({@link FornecedorRepositoryPort}),
 * enquanto este adapter lida com os detalhes de acesso ao banco de dados.
 * </p>
 */
@Component
public class FornecedorJpaAdapter implements FornecedorRepositoryPort {

    private final FornecedorJpaRepository repo;

    /**
     * Construtor da classe {@code FornecedorJpaAdapter}.
     *
     * @param repo repositório JPA responsável pelo acesso aos dados da entidade {@link Fornecedor}
     */
    public FornecedorJpaAdapter(FornecedorJpaRepository repo) {
        this.repo = repo;
    }

    /**
     * Salva um fornecedor no banco de dados.
     *
     * <p>
     * Pode ser utilizada tanto para criar um novo registro quanto para atualizar
     * um {@link Fornecedor} já existente.
     * </p>
     *
     * @param f entidade {@link Fornecedor} a ser salva
     * @return o {@link Fornecedor} salvo, possivelmente com ID gerado/atualizado
     */
    @Override
    public Fornecedor salvar(Fornecedor f) {
        return repo.save(f);
    }

    /**
     * Retorna todos os fornecedores cadastrados no banco de dados.
     *
     * @return lista contendo todas as instâncias de {@link Fornecedor} persistidas
     */
    @Override
    public List<Fornecedor> listar() {
        return repo.findAll();
    }

    /**
     * Busca um fornecedor pelo seu identificador.
     *
     * @param id identificador único do fornecedor
     * @return um {@link Optional} contendo o {@link Fornecedor} encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    @Override
    public Optional<Fornecedor> buscarPorId(Long id) {
        return repo.findById(id);
    }

    /**
     * Remove um fornecedor do banco de dados com base no seu identificador.
     *
     * @param id identificador do fornecedor a ser removido
     */
    @Override
    public void deletar(Long id) {
        repo.deleteById(id);
    }
}