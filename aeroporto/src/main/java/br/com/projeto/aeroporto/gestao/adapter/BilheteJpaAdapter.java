package br.com.projeto.aeroporto.gestao.adapter;


import br.com.projeto.aeroporto.gestao.model.Bilhete;
import br.com.projeto.aeroporto.gestao.out.BilheteRepositoryPort;
import br.com.projeto.aeroporto.gestao.repository.BilheteJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adaptador JPA para a entidade {@link Bilhete}.
 *
 * <p>
 * Implementa a porta {@link BilheteRepositoryPort} utilizando o
 * {@link BilheteJpaRepository} do Spring Data JPA como mecanismo
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
public class BilheteJpaAdapter implements BilheteRepositoryPort {

    /**
     * Repositório JPA responsável pelo acesso direto aos dados de {@link Bilhete}.
     */
    private final BilheteJpaRepository repo;

    /**
     * Construtor com injeção de dependência do repositório JPA.
     *
     * @param repo implementação de {@link BilheteJpaRepository}
     *             usada para persistir os dados de {@link Bilhete}
     */
    public BilheteJpaAdapter(BilheteJpaRepository repo) {
        this.repo = repo;
    }

    /**
     * Salva um novo bilhete ou atualiza um já existente.
     *
     * <p>
     * Delegado ao método {@link BilheteJpaRepository#save(Object)}.
     * </p>
     *
     * @param b bilhete a ser salvo
     * @return bilhete persistido
     */
    @Override
    public Bilhete salvar(Bilhete b) {
        return repo.save(b);
    }

    /**
     * Lista todos os bilhetes persistidos.
     *
     * <p>
     * Delegado ao método {@link BilheteJpaRepository#findAll()}.
     * </p>
     *
     * @return lista de bilhetes
     */
    @Override
    public List<Bilhete> listar() {
        return repo.findAll();
    }

    /**
     * Busca um bilhete pelo seu identificador.
     *
     * <p>
     * Delegado ao método {@link BilheteJpaRepository#findById(Object)}.
     * </p>
     *
     * @param id identificador do bilhete
     * @return um {@link Optional} contendo o bilhete, caso encontrado;
     * vazio caso contrário
     */
    @Override
    public Optional<Bilhete> buscarPorId(Long id) {
        return repo.findById(id);
    }

    /**
     * Remove um bilhete com base em seu identificador.
     *
     * <p>
     * Delegado ao método {@link BilheteJpaRepository#deleteById(Object)}.
     * </p>
     *
     * @param id identificador do bilhete a ser removido
     */
    @Override
    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
