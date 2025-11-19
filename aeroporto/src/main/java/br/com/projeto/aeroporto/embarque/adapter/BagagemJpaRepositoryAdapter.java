package br.com.projeto.aeroporto.embarque.adapter;


import br.com.projeto.aeroporto.embarque.model.Bagagem;
import br.com.projeto.aeroporto.embarque.out.BagagemRepositoryPort;
import br.com.projeto.aeroporto.embarque.repository.BagagemJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adapter responsável por implementar a porta {@link BagagemRepositoryPort}
 * utilizando o repositório JPA {@link BagagemJpaRepository}.
 *
 * <p>
 * Esta classe faz a ponte entre a camada de domínio e a camada de
 * persistência, seguindo o padrão de arquitetura Hexagonal (Ports and Adapters).
 * </p>
 */
@Component
public class BagagemJpaRepositoryAdapter implements BagagemRepositoryPort {

    private final BagagemJpaRepository jpaRepository;

    /**
     * Construtor da classe {@code BagagemJpaRepositoryAdapter}.
     *
     * @param jpaRepository repositório JPA responsável pelo acesso ao banco de dados
     *                      da entidade {@link Bagagem}
     */
    public BagagemJpaRepositoryAdapter(BagagemJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Salva uma bagagem no banco de dados.
     *
     * <p>
     * Caso a bagagem já exista (possua ID), os dados serão atualizados.
     * Caso contrário, uma nova bagagem será criada.
     * </p>
     *
     * @param bagagem objeto {@link Bagagem} a ser salvo
     * @return a instância de {@link Bagagem} salva, incluindo o ID gerado (se for novo registro)
     */
    @Override
    public Bagagem salvar(Bagagem bagagem) {
        return jpaRepository.save(bagagem);
    }

    /**
     * Retorna a lista de todas as bagagens cadastradas.
     *
     * @return lista de {@link Bagagem}
     */
    @Override
    public List<Bagagem> listar() {
        return jpaRepository.findAll();
    }

    /**
     * Busca uma bagagem pelo seu identificador.
     *
     * @param id identificador único da bagagem
     * @return um {@link Optional} contendo a {@link Bagagem}, caso encontrada,
     *         ou vazio se não houver registro com o ID informado
     */
    @Override
    public Optional<Bagagem> buscarPorId(Long id) {
        return jpaRepository.findById(id);
    }

    /**
     * Remove uma bagagem do banco de dados com base no seu identificador.
     *
     * @param id identificador único da bagagem a ser removida
     */
    @Override
    public void deletar(Long id) {
        jpaRepository.deleteById(id);
    }
}