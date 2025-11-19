package br.com.projeto.aeroporto.gestao.out;


import br.com.projeto.aeroporto.gestao.model.Passageiro;

import java.util.List;

/**
 * Porta de repositório para a entidade {@link Passageiro}.
 *
 * <p>
 * Define as operações de acesso a dados relacionadas a {@code Passageiro},
 * independente da tecnologia de persistência utilizada (JPA, JDBC, API externa etc.).
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface
 * representa a <b>port</b>, enquanto as implementações concretas são os
 * <b>adapters</b> que fazem a integração com o banco de dados ou outros sistemas.
 * </p>
 */
public interface PassageiroRepositoryPort {

    /**
     * Salva um novo passageiro ou atualiza um já existente.
     *
     * @param passageiro objeto contendo os dados do passageiro a ser salvo
     * @return o passageiro persistido, possivelmente com o ID preenchido
     */
    Passageiro salvar(Passageiro passageiro);

    /**
     * Lista todos os passageiros persistidos.
     *
     * @return lista de passageiros
     */
    List<Passageiro> listar();

    /**
     * Busca um passageiro pelo seu identificador.
     *
     * @param id identificador do passageiro
     * @return passageiro correspondente ao ID informado
     *         (a implementação pode optar por lançar exceção caso não seja encontrado)
     */
    Passageiro buscarPorId(Long id);

    /**
     * Remove um passageiro com base em seu identificador.
     *
     * @param id identificador do passageiro a ser removido
     */
    void deletar(Long id);
}