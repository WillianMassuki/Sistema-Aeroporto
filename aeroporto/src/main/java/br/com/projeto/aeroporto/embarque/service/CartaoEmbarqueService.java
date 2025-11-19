package br.com.projeto.aeroporto.embarque.service;


import br.com.projeto.aeroporto.embarque.in.CartaoEmbarqueUseCase;
import br.com.projeto.aeroporto.embarque.model.CartaoEmbarque;
import br.com.projeto.aeroporto.embarque.out.CartaoEmbarqueRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pelas regras de negócio relacionadas à entidade {@link CartaoEmbarque}.
 *
 * <p>
 * Implementa o caso de uso {@link CartaoEmbarqueUseCase} e utiliza a porta
 * {@link CartaoEmbarqueRepositoryPort} para acesso ao repositório, mantendo a
 * camada de domínio desacoplada dos detalhes de persistência.
 * </p>
 */
@Service
public class CartaoEmbarqueService implements CartaoEmbarqueUseCase {

    private final CartaoEmbarqueRepositoryPort repository;

    /**
     * Construtor da classe {@code CartaoEmbarqueService}.
     *
     * @param repository porta de acesso ao repositório de {@link CartaoEmbarque}
     */
    public CartaoEmbarqueService(CartaoEmbarqueRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Cria ou atualiza um cartão de embarque.
     *
     * @param cartao objeto {@link CartaoEmbarque} a ser salvo
     * @return o {@link CartaoEmbarque} salvo, possivelmente com ID gerado/atualizado
     */
    @Override
    public CartaoEmbarque salvar(CartaoEmbarque cartao) {
        return repository.salvar(cartao);
    }

    /**
     * Lista todos os cartões de embarque cadastrados.
     *
     * @return lista contendo todos os {@link CartaoEmbarque} persistidos
     */
    @Override
    public List<CartaoEmbarque> listar() {
        return repository.listar();
    }

    /**
     * Busca um cartão de embarque pelo seu identificador.
     *
     * @param id identificador único do cartão de embarque
     * @return o {@link CartaoEmbarque} correspondente ao ID informado
     * @throws RuntimeException caso nenhum cartão seja encontrado para o ID informado
     */
    @Override
    public CartaoEmbarque buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Cartão não encontrado"));
    }

    /**
     * Atualiza os dados de um cartão de embarque existente.
     *
     * <p>
     * Primeiro busca o cartão atual pelo ID; em seguida, altera os campos
     * {@code codigoCartaoEmbarque} e {@code assento} com base nos dados
     * do novo cartão informado e salva novamente no repositório.
     * </p>
     *
     * @param id   identificador do cartão a ser atualizado
     * @param novo objeto {@link CartaoEmbarque} contendo os novos dados
     * @return o {@link CartaoEmbarque} atualizado
     * @throws RuntimeException caso o cartão não seja encontrado
     */
    @Override
    public CartaoEmbarque atualizar(Long id, CartaoEmbarque novo) {
        CartaoEmbarque atual = buscarPorId(id);
        atual.setCodigoCartaoEmbarque(novo.getCodigoCartaoEmbarque());
        atual.setAssento(novo.getAssento());
        return repository.salvar(atual);
    }

    /**
     * Remove um cartão de embarque com base no seu identificador.
     *
     * @param id identificador do cartão de embarque a ser removido
     */
    @Override
    public void deletar(Long id) {
        repository.deletar(id);
    }
}