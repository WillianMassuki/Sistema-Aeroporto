package br.com.projeto.aeroporto.controlevoo.in;


import br.com.projeto.aeroporto.controlevoo.model.Controlador;

import java.util.List;

/**
 * Caso de uso responsável pelas operações de negócio relacionadas
 * à entidade {@link Controlador}.
 *
 * <p>
 * Esta interface define o contrato da camada de aplicação/serviço para
 * manipulação de controladores, independente de detalhes de infraestrutura
 * (como banco de dados, mensageria, etc.).
 * </p>
 */
public interface ControladorUseCase {

    /**
     * Cria um novo controlador.
     *
     * @param controlador objeto {@link Controlador} a ser criado
     * @return o {@link Controlador} criado e persistido
     */
    Controlador create(Controlador controlador);

    /**
     * Atualiza os dados de um controlador existente.
     *
     * @param id          identificador do controlador a ser atualizado
     * @param controlador objeto {@link Controlador} contendo os novos dados
     * @return o {@link Controlador} atualizado
     * @throws RuntimeException (ou exceção específica) caso o controlador não seja encontrado
     */
    Controlador update(Long id, Controlador controlador);

    /**
     * Busca um controlador pelo seu identificador.
     *
     * @param id identificador único do controlador
     * @return o {@link Controlador} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o controlador não seja encontrado
     */
    Controlador getById(Long id);

    /**
     * Retorna todos os controladores cadastrados.
     *
     * @return lista contendo todas as instâncias de {@link Controlador} persistidas
     */
    List<Controlador> getAll();

    /**
     * Remove um controlador com base no seu identificador.
     *
     * @param id identificador do controlador a ser removido
     */
    void delete(Long id);
}