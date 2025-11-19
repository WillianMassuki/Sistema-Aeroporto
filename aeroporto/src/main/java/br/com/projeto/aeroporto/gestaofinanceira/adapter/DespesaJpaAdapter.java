package br.com.projeto.aeroporto.gestaofinanceira.adapter;


import br.com.projeto.aeroporto.gestaofinanceira.model.Despesa;
import br.com.projeto.aeroporto.gestaofinanceira.out.DespesaRepositoryPort;
import br.com.projeto.aeroporto.gestaofinanceira.repository.DespesaJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adapter responsável por implementar a porta {@link DespesaRepositoryPort}
 * utilizando o repositório JPA {@link DespesaJpaRepository}.
 *
 * <p>
 * Esta classe faz a ponte entre a camada de domínio e a camada de persistência,
 * seguindo o padrão de arquitetura Hexagonal (Ports and Adapters).
 * O domínio depende apenas da interface (porta), enquanto este adapter cuida
 * dos detalhes de acesso ao banco de dados.
 * </p>
 */
@Component
public class DespesaJpaAdapter implements DespesaRepositoryPort {

    private final DespesaJpaRepository repo;

    /**
     * Construtor da classe {@code DespesaJpaAdapter}.
     *
     * @param repo repositório JPA responsável pelo acesso aos dados da entidade {@link Despesa}
     */
    public DespesaJpaAdapter(DespesaJpaRepository repo) {
        this.repo = repo;
    }

    /**
     * Salva uma despesa no banco de dados.
     *
     * <p>
     * Pode ser utilizada tanto para criar um novo registro quanto para atualizar
     * uma {@link Despesa} já existente.
     * </p>
     *
     * @param d entidade {@link Despesa} a ser salva
     * @return a {@link Despesa} salva, possivelmente com ID gerado/atualizado
     */
    @Override
    public Despesa salvar(Despesa d) {
        return repo.save(d);
    }

    /**
     * Retorna todas as despesas cadastradas no banco de dados.
     *
     * @return lista contendo todas as instâncias de {@link Despesa} persistidas
     */
    @Override
    public List<Despesa> listar() {
        return repo.findAll();
    }

    /**
     * Busca uma despesa pelo seu identificador.
     *
     * @param id identificador único da despesa
     * @return um {@link Optional} contendo a {@link Despesa} encontrada,
     *         ou vazio caso não exista registro com o ID informado
     */
    @Override
    public Optional<Despesa> buscarPorId(Long id) {
        return repo.findById(id);
    }

    /**
     * Remove uma despesa do banco de dados com base no seu identificador.
     *
     * @param id identificador da despesa a ser removida
     */
    @Override
    public void deletar(Long id) {
        repo.deleteById(id);
    }
}