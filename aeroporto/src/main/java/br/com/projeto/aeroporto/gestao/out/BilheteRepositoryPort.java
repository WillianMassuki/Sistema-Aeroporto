package br.com.projeto.aeroporto.gestao.out;


import br.com.projeto.aeroporto.gestao.model.Bilhete;

import java.util.List;
import java.util.Optional;

/**
 * Porta de repositório para a entidade {@link Bilhete}.
 *
 * <p>
 * Define as operações de acesso a dados relacionadas a {@code Bilhete},
 * independente da tecnologia de persistência utilizada (JPA, JDBC, API externa etc.).
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface
 * representa a <b>port</b>, enquanto as implementações concretas são os
 * <b>adapters</b> que fazem a integração com o banco de dados ou outros sistemas.
 * </p>
 */
public interface BilheteRepositoryPort {

    /**
     * Salva um novo bilhete ou atualiza um já existente.
     *
     * @param bilhete objeto contendo os dados do bilhete a ser salvo
     * @return o bilhete persistido, possivelmente com o ID preenchido
     */
    Bilhete salvar(Bilhete bilhete);

    /**
     * Lista todos os bilhetes persistidos.
     *
     * @return lista de bilhetes
     */
    List<Bilhete> listar();

    /**
     * Busca um bilhete pelo seu identificador.
     *
     * @param id identificador do bilhete
     * @return um {@link Optional} contendo o bilhete, caso encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<Bilhete> buscarPorId(Long id);

    /**
     * Remove um bilhete com base em seu identificador.
     *
     * @param id identificador do bilhete a ser removido
     */
    void deletar(Long id);
}