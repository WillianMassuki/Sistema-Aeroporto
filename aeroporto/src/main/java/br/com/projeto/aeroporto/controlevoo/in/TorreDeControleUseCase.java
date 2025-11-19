package br.com.projeto.aeroporto.controlevoo.in;


import br.com.projeto.aeroporto.controlevoo.model.TorreDeControle;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


/**
 * Caso de uso responsável pelas operações de negócio relacionadas
 * à entidade {@link TorreDeControle}.
 *
 * <p>
 * Esta interface define o contrato da camada de aplicação/serviço para
 * manipulação de torres de controle, de forma independente de detalhes
 * de infraestrutura (como banco de dados, mensageria etc.).
 * </p>
 *
 * <p>
 * A anotação {@link Component} permite que uma implementação dessa interface
 * possa ser gerenciada pelo Spring como um bean, quando utilizada em conjunto
 * com proxies ou configurações específicas.
 * </p>
 */
@Component
public interface TorreDeControleUseCase {

    /**
     * Cria uma nova torre de controle.
     *
     * @param torreDeControle objeto {@link TorreDeControle} a ser criado
     * @return a {@link TorreDeControle} criada e persistida
     */
    TorreDeControle create(TorreDeControle torreDeControle);

    // Método comentado que poderia ser utilizado futuramente para atualização.
    // TorreDeControle update(Long id, TorreDeControle torreDeControle);

    /**
     * Busca uma torre de controle pelo seu identificador.
     *
     * @param id identificador único da torre de controle
     * @return um {@link Optional} contendo a {@link TorreDeControle} encontrada,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<TorreDeControle> getById(Long id);

    /**
     * Retorna todas as torres de controle cadastradas.
     *
     * @return lista contendo todas as instâncias de {@link TorreDeControle} persistidas
     */
    List<TorreDeControle> getAll();

    /**
     * Remove uma torre de controle com base no seu identificador.
     *
     * @param id identificador da torre de controle a ser removida
     */
    void delete(Long id);
}