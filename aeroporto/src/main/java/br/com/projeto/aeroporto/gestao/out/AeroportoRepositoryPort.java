package br.com.projeto.aeroporto.gestao.out;


import br.com.projeto.aeroporto.gestao.model.Aeroporto;

import java.util.List;
import java.util.Optional;

/**
 * Porta de repositório para a entidade {@link Aeroporto}.
 *
 * Define as operações de acesso a dados relacionadas a {@code Aeroporto},
 * independente da tecnologia de persistência (JPA, JDBC, API externa etc.).
 * Em uma arquitetura hexagonal (ou ports and adapters), esta interface
 * representa a <b>port</b>, enquanto as implementações concretas são os
 * <b>adapters</b> que conversam com o banco de dados ou outros sistemas.
 */
public interface AeroportoRepositoryPort {

    /**
     * Salva um novo aeroporto ou atualiza um já existente.
     *
     * @param aeroporto objeto contendo os dados do aeroporto a ser salvo
     * @return o aeroporto persistido, possivelmente com o ID preenchido
     */
    Aeroporto salvar(Aeroporto aeroporto);

    /**
     * Lista todos os aeroportos persistidos.
     *
     * @return lista de aeroportos
     */
    List<Aeroporto> listar();

    /**
     * Busca um aeroporto pelo seu identificador.
     *
     * @param id identificador do aeroporto
     * @return um {@link Optional} contendo o aeroporto, caso encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<Aeroporto> buscarPorId(Long id);

    /**
     * Remove um aeroporto com base em seu identificador.
     *
     * @param id identificador do aeroporto a ser removido
     */
    void deletar(Long id);
}