package br.com.projeto.aeroporto.embarque.adapter;


import br.com.projeto.aeroporto.embarque.model.CartaoEmbarque;
import br.com.projeto.aeroporto.embarque.out.CartaoEmbarqueRepositoryPort;
import br.com.projeto.aeroporto.embarque.repository.CartaoEmbarqueRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adapter responsável por implementar a porta {@link CartaoEmbarqueRepositoryPort}
 * utilizando o repositório JPA {@link CartaoEmbarqueRepository}.
 *
 * <p>
 * Esta classe faz a ponte entre a camada de domínio e a camada de persistência,
 * seguindo o padrão de arquitetura Hexagonal (Ports and Adapters).
 * Assim, o domínio depende apenas da interface (porta) e não de detalhes de infraestrutura.
 * </p>
 */
@Component
public class CartaoEmbarqueJpaAdapter implements CartaoEmbarqueRepositoryPort {

    private final CartaoEmbarqueRepository repo;

    /**
     * Construtor da classe {@code CartaoEmbarqueJpaAdapter}.
     *
     * @param repo repositório JPA responsável pelo acesso ao banco de dados
     *             da entidade {@link CartaoEmbarque}
     */
    public CartaoEmbarqueJpaAdapter(CartaoEmbarqueRepository repo) {
        this.repo = repo;
    }

    /**
     * Salva um cartão de embarque no banco de dados.
     *
     * <p>
     * Caso o cartão já exista (possua ID), os dados serão atualizados.
     * Caso contrário, um novo registro será criado.
     * </p>
     *
     * @param c objeto {@link CartaoEmbarque} a ser salvo
     * @return a instância de {@link CartaoEmbarque} salva, incluindo o ID gerado (se for novo registro)
     */
    @Override
    public CartaoEmbarque salvar(CartaoEmbarque c) {
        return repo.save(c);
    }

    /**
     * Retorna a lista de todos os cartões de embarque cadastrados.
     *
     * @return lista de {@link CartaoEmbarque}
     */
    @Override
    public List<CartaoEmbarque> listar() {
        return repo.findAll();
    }

    /**
     * Busca um cartão de embarque pelo seu identificador.
     *
     * @param id identificador único do cartão de embarque
     * @return um {@link Optional} contendo o {@link CartaoEmbarque}, caso encontrado,
     *         ou vazio se não houver registro com o ID informado
     */
    @Override
    public Optional<CartaoEmbarque> buscarPorId(Long id) {
        return repo.findById(id);
    }

    /**
     * Remove um cartão de embarque do banco de dados com base no seu identificador.
     *
     * @param id identificador único do cartão de embarque a ser removido
     */
    @Override
    public void deletar(Long id) {
        repo.deleteById(id);
    }
}