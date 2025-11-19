package br.com.projeto.aeroporto.gestao.adapter;


import br.com.projeto.aeroporto.gestao.model.Passageiro;
import br.com.projeto.aeroporto.gestao.out.PassageiroRepositoryPort;
import br.com.projeto.aeroporto.gestao.repository.PassageiroJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Adaptador JPA para a entidade {@link Passageiro}.
 *
 * <p>
 * Implementa a porta {@link PassageiroRepositoryPort} utilizando o
 * {@link PassageiroJpaRepository} do Spring Data JPA como mecanismo
 * de persistência.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe atua como
 * <b>adapter de infraestrutura</b>, fazendo a ponte entre a camada de aplicação
 * (que conhece apenas a port) e o banco de dados.
 * </p>
 */
@Component
public class PassageiroJpaAdapter implements PassageiroRepositoryPort {

    /**
     * Repositório JPA responsável pelo acesso direto aos dados de {@link Passageiro}.
     */
    private final PassageiroJpaRepository repo;

    /**
     * Construtor com injeção de dependência do repositório JPA.
     *
     * @param repo implementação de {@link PassageiroJpaRepository}
     *             usada para persistir os dados de {@link Passageiro}
     */
    public PassageiroJpaAdapter(PassageiroJpaRepository repo) {
        this.repo = repo;
    }

    /**
     * Salva um novo passageiro ou atualiza um já existente.
     *
     * <p>
     * Delegado ao método {@link PassageiroJpaRepository#save(Object)}.
     * </p>
     *
     * @param p passageiro a ser salvo
     * @return passageiro persistido
     */
    @Override
    public Passageiro salvar(Passageiro p) {
        return  repo.save(p);
    }

    /**
     * Lista todos os passageiros persistidos.
     *
     * <p>
     * Delegado ao método {@link PassageiroJpaRepository#findAll()}.
     * </p>
     *
     * @return lista de passageiros
     */
    @Override
    public List<Passageiro> listar() {
        return repo.findAll();
    }

    /**
     * Busca um passageiro pelo seu identificador.
     *
     * <p>
     * <b>Atenção:</b> a implementação atual retorna {@code null} e serve apenas
     * como um "stub". Ela deve ser ajustada para delegar ao repositório JPA
     * (por exemplo, usando {@code repo.findById(id)}) conforme a regra de negócio
     * desejada (retornar {@code null}, lançar exceção, etc.).
     * </p>
     *
     * @param id identificador do passageiro
     * @return passageiro correspondente ao ID informado (ou {@code null}, na
     *         implementação atual)
     */
    @Override
    public Passageiro buscarPorId(Long id) {
        return null;
    }

    /*
    // Implementação sugerida (exemplo):
    public Passageiro buscarPorId(Long id) {
        return repo.findById(id).orElse(null); // ou .orElseThrow(...)
    }
    */

    /**
     * Remove um passageiro com base em seu identificador.
     *
     * <p>
     * Delegado ao método {@link PassageiroJpaRepository#deleteById(Object)}.
     * </p>
     *
     * @param id identificador do passageiro a ser removido
     */
    @Override
    public void deletar(Long id) {
        repo.deleteById(id);
    }
}
