package br.com.projeto.aeroporto.embarque.in;


import br.com.projeto.aeroporto.embarque.model.CartaoEmbarque;

import java.util.List;

/**
 * Caso de uso responsável pelas operações de negócio relacionadas
 * à entidade {@link CartaoEmbarque}.
 *
 * <p>
 * Esta interface define o contrato da camada de aplicação/serviço para
 * manipulação de cartões de embarque, independente de detalhes de
 * infraestrutura (como banco de dados, mensageria, etc.).
 * </p>
 */
public interface CartaoEmbarqueUseCase {

    /**
     * Cria ou atualiza um cartão de embarque.
     *
     * @param cartao objeto {@link CartaoEmbarque} a ser salvo
     * @return o {@link CartaoEmbarque} salvo, possivelmente com ID gerado/atualizado
     */
    CartaoEmbarque salvar(CartaoEmbarque cartao);

    /**
     * Lista todos os cartões de embarque cadastrados.
     *
     * @return uma lista contendo todos os {@link CartaoEmbarque} persistidos
     */
    List<CartaoEmbarque> listar();

    /**
     * Busca um cartão de embarque pelo seu identificador.
     *
     * @param id identificador único do cartão de embarque
     * @return o {@link CartaoEmbarque} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o cartão não seja encontrado
     */
    CartaoEmbarque buscarPorId(Long id);

    /**
     * Atualiza os dados de um cartão de embarque existente.
     *
     * @param id    identificador do cartão de embarque a ser atualizado
     * @param cartao objeto {@link CartaoEmbarque} contendo os novos dados
     * @return o {@link CartaoEmbarque} atualizado
     */
    CartaoEmbarque atualizar(Long id, CartaoEmbarque cartao);

    /**
     * Remove um cartão de embarque com base no seu identificador.
     *
     * @param id identificador do cartão de embarque a ser removido
     */
    void deletar(Long id);
}