package br.com.projeto.aeroporto.controlevoo.out;


import br.com.projeto.aeroporto.controlevoo.model.Controlador;

import java.util.List;
import java.util.Optional;

/**
 * Porta (interface) de acesso ao repositório de {@link Controlador}.
 *
 * <p>
 * Define o contrato que a camada de infraestrutura deve implementar para
 * realizar operações de persistência de controladores, mantendo o domínio
 * desacoplado de detalhes específicos de banco de dados ou tecnologia.
 * </p>
 */
public interface ControladorRepositoryPort {

    /**
     * Salva um controlador no repositório.
     *
     * <p>
     * Pode ser utilizada tanto para criação quanto para atualização de registros.
     * </p>
     *
     * @param controlador objeto {@link Controlador} a ser salvo
     * @return o {@link Controlador} salvo, possivelmente com ID gerado/atualizado
     */
    Controlador save(Controlador controlador);

    /**
     * Busca um controlador pelo seu identificador.
     *
     * @param id identificador único do controlador
     * @return um {@link Optional} contendo o {@link Controlador} encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<Controlador> findById(Long id);

    /**
     * Retorna todos os controladores armazenados no repositório.
     *
     * @return lista contendo todas as instâncias de {@link Controlador} persistidas
     */
    List<Controlador> findAll();

    /**
     * Remove um controlador do repositório com base no seu identificador.
     *
     * @param id identificador do controlador a ser removido
     */
    void deleteById(Long id);
}