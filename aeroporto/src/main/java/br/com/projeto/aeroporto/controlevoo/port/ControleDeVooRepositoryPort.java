package br.com.projeto.aeroporto.controlevoo.port;


import br.com.projeto.aeroporto.controlevoo.model.ControleDeVoo;

import java.util.List;
import java.util.Optional;

/**
 * Porta (interface) de acesso ao repositório de {@link ControleDeVoo}.
 *
 * <p>
 * Define o contrato que a camada de infraestrutura deve implementar para
 * realizar operações de persistência de registros de controle de voo, mantendo
 * o domínio desacoplado de detalhes específicos de banco de dados ou tecnologia.
 * </p>
 */
public interface ControleDeVooRepositoryPort {

    /**
     * Salva um registro de controle de voo no repositório.
     *
     * <p>
     * Pode ser utilizada tanto para criação quanto para atualização de registros.
     * </p>
     *
     * @param voo objeto {@link ControleDeVoo} a ser salvo
     * @return o {@link ControleDeVoo} salvo, possivelmente com ID gerado/atualizado
     */
    ControleDeVoo save(ControleDeVoo voo);

    /**
     * Retorna todos os registros de controle de voo armazenados no repositório.
     *
     * @return lista contendo todas as instâncias de {@link ControleDeVoo} persistidas
     */
    List<ControleDeVoo> findAll();

    /**
     * Busca um registro de controle de voo pelo seu identificador.
     *
     * @param id identificador único do controle de voo
     * @return um {@link Optional} contendo o {@link ControleDeVoo} encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<ControleDeVoo> findById(Long id);

    /**
     * Remove um registro de controle de voo do repositório com base no seu identificador.
     *
     * @param id identificador do registro de controle de voo a ser removido
     */
    void deleteById(Long id);
}