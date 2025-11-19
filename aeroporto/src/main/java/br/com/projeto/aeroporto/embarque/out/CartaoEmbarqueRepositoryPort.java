package br.com.projeto.aeroporto.embarque.out;


import br.com.projeto.aeroporto.embarque.model.CartaoEmbarque;

import java.util.List;
import java.util.Optional;

/**
 * Porta (interface) de acesso ao repositório de {@link CartaoEmbarque}.
 *
 * <p>
 * Define o contrato que a camada de infraestrutura deve implementar para
 * realizar operações de persistência de cartões de embarque, mantendo o domínio
 * desacoplado de detalhes específicos de banco de dados ou tecnologia.
 * </p>
 */
public interface CartaoEmbarqueRepositoryPort {

    /**
     * Salva um cartão de embarque no repositório.
     *
     * <p>
     * Pode ser utilizada tanto para criação quanto para atualização de registros.
     * </p>
     *
     * @param cartao objeto {@link CartaoEmbarque} a ser salvo
     * @return o {@link CartaoEmbarque} salvo, possivelmente com ID gerado/atualizado
     */
    CartaoEmbarque salvar(CartaoEmbarque cartao);

    /**
     * Retorna todos os cartões de embarque armazenados no repositório.
     *
     * @return lista contendo todos os {@link CartaoEmbarque} persistidos
     */
    List<CartaoEmbarque> listar();

    /**
     * Busca um cartão de embarque pelo seu identificador.
     *
     * @param id identificador único do cartão de embarque
     * @return um {@link Optional} contendo o {@link CartaoEmbarque} encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<CartaoEmbarque> buscarPorId(Long id);

    /**
     * Remove um cartão de embarque do repositório com base no seu identificador.
     *
     * @param id identificador do cartão de embarque a ser removido
     */
    void deletar(Long id);
}