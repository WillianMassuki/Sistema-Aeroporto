package br.com.projeto.aeroporto.embarque.in;


import br.com.projeto.aeroporto.embarque.model.Bagagem;

import java.util.List;

/**
 * Caso de uso responsável pelas operações de negócio relacionadas à entidade {@link Bagagem}.
 *
 * <p>
 * Esta interface define o contrato da camada de aplicação/serviço para manipulação
 * de bagagens, independente de detalhes de infraestrutura (como banco de dados).
 * </p>
 */
public interface BagagemUseCase {

    /**
     * Cria ou atualiza uma bagagem.
     *
     * @param bagagem objeto {@link Bagagem} a ser salvo
     * @return a {@link Bagagem} salva, possivelmente com ID atualizado/gerado
     */
    Bagagem salvar(Bagagem bagagem);

    /**
     * Lista todas as bagagens cadastradas.
     *
     * @return uma lista contendo todas as {@link Bagagem} persistidas
     */
    List<Bagagem> listar();

    /**
     * Busca uma bagagem pelo seu identificador.
     *
     * @param id identificador único da bagagem
     * @return a {@link Bagagem} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso a bagagem não seja encontrada
     */
    Bagagem buscarPorId(Long id);

    /**
     * Atualiza os dados de uma bagagem existente.
     *
     * @param id      identificador da bagagem a ser atualizada
     * @param bagagem objeto {@link Bagagem} contendo os novos dados
     * @return a {@link Bagagem} atualizada
     */
    Bagagem atualizar(Long id, Bagagem bagagem);

    /**
     * Remove uma bagagem com base no seu identificador.
     *
     * @param id identificador da bagagem a ser removida
     */
    void deletar(Long id);
}