package br.com.projeto.aeroporto.gestaofinanceira.in;


import br.com.projeto.aeroporto.gestaofinanceira.model.Fornecedor;

import java.util.List;

/**
 * Caso de uso responsável pelas operações de negócio relacionadas à entidade {@link Fornecedor}.
 *
 * <p>
 * Esta interface define o contrato da camada de aplicação/serviço para manipulação
 * de fornecedores, mantendo a lógica de negócio desacoplada de detalhes de
 * infraestrutura (como banco de dados, APIs externas etc.).
 * </p>
 */
public interface FornecedorUseCase {

    /**
     * Cria ou atualiza um fornecedor.
     *
     * @param fornecedor objeto {@link Fornecedor} a ser salvo
     * @return o {@link Fornecedor} salvo, possivelmente com ID gerado/atualizado
     */
    Fornecedor salvar(Fornecedor fornecedor);

    /**
     * Lista todos os fornecedores cadastrados.
     *
     * @return uma lista contendo todos os {@link Fornecedor} persistidos
     */
    List<Fornecedor> listar();

    /**
     * Busca um fornecedor pelo seu identificador.
     *
     * @param id identificador único do fornecedor
     * @return o {@link Fornecedor} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o fornecedor não seja encontrado
     */
    Fornecedor buscarPorId(Long id);

    /**
     * Atualiza os dados de um fornecedor existente.
     *
     * @param id         identificador do fornecedor a ser atualizado
     * @param fornecedor objeto {@link Fornecedor} contendo os novos dados
     * @return o {@link Fornecedor} atualizado
     * @throws RuntimeException (ou exceção específica) caso o fornecedor não seja encontrado
     */
    Fornecedor atualizar(Long id, Fornecedor fornecedor);

    /**
     * Remove um fornecedor com base no seu identificador.
     *
     * @param id identificador do fornecedor a ser removido
     */
    void deletar(Long id);
}