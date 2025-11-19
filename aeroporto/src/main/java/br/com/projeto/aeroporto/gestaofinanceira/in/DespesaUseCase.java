package br.com.projeto.aeroporto.gestaofinanceira.in;


import br.com.projeto.aeroporto.gestaofinanceira.model.Despesa;

import java.util.List;

/**
 * Caso de uso responsável pelas operações de negócio relacionadas à entidade {@link Despesa}.
 *
 * <p>
 * Esta interface define o contrato da camada de aplicação/serviço para manipulação
 * de despesas, independente de detalhes de infraestrutura (como banco de dados, etc.).
 * </p>
 */
public interface DespesaUseCase {

    /**
     * Cria ou atualiza uma despesa.
     *
     * @param despesa objeto {@link Despesa} a ser salvo
     * @return a {@link Despesa} salva, possivelmente com ID gerado/atualizado
     */
    Despesa salvar(Despesa despesa);

    /**
     * Lista todas as despesas cadastradas.
     *
     * @return uma lista contendo todas as {@link Despesa} persistidas
     */
    List<Despesa> listar();

    /**
     * Busca uma despesa pelo seu identificador.
     *
     * @param id identificador único da despesa
     * @return a {@link Despesa} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso a despesa não seja encontrada
     */
    Despesa buscarPorId(Long id);

    // Método de atualização comentado que pode ser utilizado futuramente.
    // Despesa atualizar(Long id, Despesa despesa);

    /**
     * Remove uma despesa com base no seu identificador.
     *
     * @param id identificador da despesa a ser removida
     */
    void deletar(Long id);
}