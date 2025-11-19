package br.com.projeto.aeroporto.gestao.repository;


import br.com.projeto.aeroporto.gestao.model.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Passageiro}.
 *
 * <p>
 * Estende {@link JpaRepository}, fornecendo automaticamente operações básicas
 * de persistência (CRUD), além de suporte a paginação e ordenação para
 * objetos do tipo {@code Passageiro}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface pode atuar
 * como um <b>adapter</b> de infraestrutura que implementa a porta
 * {@code PassageiroRepositoryPort}, caso ela exista na aplicação.
 * </p>
 */
@Repository
public interface PassageiroJpaRepository extends JpaRepository<Passageiro, Long> {
    // Métodos de consulta adicionais (query methods) podem ser declarados aqui, se necessário.
}
