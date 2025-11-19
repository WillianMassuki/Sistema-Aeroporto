package br.com.projeto.aeroporto.controlevoo.port;


import br.com.projeto.aeroporto.controlevoo.model.ControleDeVoo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Porta (interface) de serviço para operações de negócio relacionadas
 * à entidade {@link ControleDeVoo}.
 *
 * <p>
 * Esta interface define o contrato da camada de serviço para manipulação
 * de controles de voo. Alguns métodos possuem implementação {@code default}
 * retornando {@code null}, funcionando apenas como placeholders e devendo
 * ser sobrescritos pelas classes concretas.
 * </p>
 *
 * <p>
 * A anotação {@link Component} permite que uma implementação dessa interface
 * possa ser gerenciada pelo Spring como um bean, quando utilizada com proxies
 * ou configurações específicas.
 * </p>
 */
@Component
public interface ControleDeVooServicePort {

    /**
     * Cria um novo controle de voo.
     *
     * <p>
     * Implementação padrão retorna {@code null}. É esperado que
     * as classes concretas sobrescrevam este método com a lógica
     * de criação e persistência.
     * </p>
     *
     * @param controle objeto {@link ControleDeVoo} a ser criado
     * @return o {@link ControleDeVoo} criado e persistido
     */
    default ControleDeVoo criarControle(ControleDeVoo controle) {
        return null;
    }

    /**
     * Atualiza os dados de um controle de voo existente.
     *
     * <p>
     * Implementação padrão retorna {@code null}. É esperado que
     * as classes concretas sobrescrevam este método com a lógica
     * de atualização.
     * </p>
     *
     * @param id       identificador do controle de voo a ser atualizado
     * @param controle objeto {@link ControleDeVoo} contendo os novos dados
     * @return o {@link ControleDeVoo} atualizado
     */
    default ControleDeVoo atualizarControle(Long id, ControleDeVoo controle) {
        return null;
    }

    /**
     * Busca um controle de voo pelo seu identificador.
     *
     * @param id identificador único do controle de voo
     * @return o {@link ControleDeVoo} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o controle não seja encontrado
     */
    ControleDeVoo buscarPorId(Long id);

    /**
     * Retorna todos os controles de voo cadastrados.
     *
     * <p>
     * Implementação padrão retorna {@code null}. É esperado que
     * as classes concretas sobrescrevam este método com a lógica
     * de listagem.
     * </p>
     *
     * @return lista contendo todas as instâncias de {@link ControleDeVoo} persistidas
     */
    default List<ControleDeVoo> listarTodos() {
        return null;
    }

    /**
     * Remove um controle de voo com base no seu identificador.
     *
     * @param id identificador do controle de voo a ser removido
     */
    void deletar(Long id);
}