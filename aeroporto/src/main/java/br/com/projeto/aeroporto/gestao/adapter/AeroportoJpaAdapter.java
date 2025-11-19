package br.com.projeto.aeroporto.gestao.adapter;


import br.com.projeto.aeroporto.gestao.model.Aeroporto;
import br.com.projeto.aeroporto.gestao.out.AeroportoRepositoryPort;
import br.com.projeto.aeroporto.gestao.repository.AeroportoJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador JPA para a entidade {@link Aeroporto}.
 *
 * <p>
 * Implementa a porta {@link AeroportoRepositoryPort} utilizando o
 * {@link AeroportoJpaRepository} do Spring Data JPA como mecanismo
 * de persistência.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe
 * é um <b>adapter de infraestrutura</b>, fazendo a ponte entre
 * a camada de aplicação (que conhece apenas a port) e o banco de dados.
 * </p>
 */
@Component
public class AeroportoJpaAdapter implements AeroportoRepositoryPort {

    /**
     * Repositório JPA responsável pelo acesso direto ao banco de dados.
     */
    private final AeroportoJpaRepository repo;

    /**
     * Construtor com injeção de dependência do repositório JPA.
     *
     * @param repo implementação de {@link AeroportoJpaRepository}
     *             usada para persistir os dados de {@link Aeroporto}
     */
    public AeroportoJpaAdapter(AeroportoJpaRepository repo) {
        this.repo = repo;
    }

    /**
     * Salva um novo aeroporto ou atualiza um já existente.
     *
     * <p>
     * Delegado ao método {@link AeroportoJpaRepository#save(Object)}.
     * </p>
     *
     * @param a aeroporto a ser salvo
     * @return aeroporto persistido
     */
    @Override
    public Aeroporto salvar(Aeroporto a) {
        return repo.save(a);
    }

    /**
     * Lista todos os aeroportos persistidos.
     *
     * <p>
     * Delegado ao método {@link AeroportoJpaRepository#findAll()}.
     * </p>
     *
     * @return lista de aeroportos
     */
    @Override
    public List<Aeroporto> listar() {
        return repo.findAll();
    }

    /**
     * Busca um aeroporto pelo seu identificador.
     *
     * <p>
     * Delegado ao método {@link AeroportoJpaRepository#findById(Object)}.
     * </p>
     *
     * @param id identificador do aeroporto
     * @return um {@link Optional} contendo o aeroporto, caso encontrado;
     *         vazio caso contrário
     */
    @Override
    public Optional<Aeroporto> buscarPorId(Long id) {
        return repo.findById(id);
    }

    /**
     * Remove um aeroporto com base em seu identificador.
     *
     * <p>
     * Delegado ao método {@link AeroportoJpaRepository#deleteById(Object)}.
     * </p>
     *
     * @param id identificador do aeroporto a ser removido
     */
    @Override
    public void deletar(Long id) {
        repo.deleteById(id);
    }
}