package br.com.projeto.aeroporto.controlevoo.in;

import br.com.projeto.aeroporto.controlevoo.model.ControleDeVoo;

import java.util.List;

/**
 * Caso de uso responsável pelas operações de negócio relacionadas
 * à entidade {@link ControleDeVoo}.
 *
 * <p>
 * Esta interface define o contrato da camada de aplicação/serviço para
 * manipulação de registros de controle de voo, de forma independente
 * de detalhes de infraestrutura (como banco de dados, filas, etc.).
 * </p>
 */
public interface ControleDeVooUseCase {

    /**
     * Cria um novo registro de controle de voo.
     *
     * @param controleDeVoo objeto {@link ControleDeVoo} a ser criado
     * @return o {@link ControleDeVoo} criado e persistido
     */
    ControleDeVoo create(ControleDeVoo controleDeVoo);

    /**
     * Atualiza os dados de um controle de voo existente.
     *
     * @param id            identificador do controle de voo a ser atualizado
     * @param controleDeVoo objeto {@link ControleDeVoo} contendo os novos dados
     * @return o {@link ControleDeVoo} atualizado
     * @throws RuntimeException (ou exceção específica) caso o registro não seja encontrado
     */
    ControleDeVoo update(Long id, ControleDeVoo controleDeVoo);

    /**
     * Busca um controle de voo pelo seu identificador.
     *
     * @param id identificador único do controle de voo
     * @return o {@link ControleDeVoo} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o registro não seja encontrado
     */
    ControleDeVoo getById(Long id);

    /**
     * Retorna todos os registros de controle de voo cadastrados.
     *
     * @return lista contendo todas as instâncias de {@link ControleDeVoo} persistidas
     */
    List<ControleDeVoo> getAll();

    /**
     * Remove um registro de controle de voo com base no seu identificador.
     *
     * @param id identificador do registro de controle de voo a ser removido
     */
    void delete(Long id);
}