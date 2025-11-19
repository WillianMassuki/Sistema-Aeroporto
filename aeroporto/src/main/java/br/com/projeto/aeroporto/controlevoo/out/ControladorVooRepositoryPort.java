package br.com.projeto.aeroporto.controlevoo.out;


import br.com.projeto.aeroporto.controlevoo.model.ControleDeVoo;

import java.util.List;

/**
 * Porta (interface) de acesso ao repositório de {@link ControleDeVoo}.
 *
 * <p>
 * Define o contrato que a camada de infraestrutura deve implementar para
 * realizar operações de persistência de registros de controle de voo,
 * mantendo o domínio desacoplado de detalhes específicos de banco de dados
 * ou tecnologia.
 * </p>
 */
public interface ControladorVooRepositoryPort {

    /**
     * Salva um registro de controle de voo no repositório.
     *
     * <p>
     * Pode ser utilizada tanto para criação quanto para atualização de registros.
     * </p>
     *
     * @param controleDeVoo objeto {@link ControleDeVoo} a ser salvo
     * @return o {@link ControleDeVoo} salvo, possivelmente com ID gerado/atualizado
     */
    ControleDeVoo save(ControleDeVoo controleDeVoo);

    // Método comentado que poderia ser utilizado futuramente para busca por ID.
    // Optional<ControleDeVoo> findById(Long id);

    /**
     * Retorna todos os registros de controle de voo armazenados no repositório.
     *
     * @return lista contendo todas as instâncias de {@link ControleDeVoo} persistidas
     */
    List<ControleDeVoo> findAll();

    /**
     * Remove um registro de controle de voo do repositório com base no seu identificador.
     *
     * @param id identificador do registro de controle de voo a ser removido
     */
    void deleteById(Long id);
}