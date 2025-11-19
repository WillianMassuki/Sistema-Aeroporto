package br.com.projeto.aeroporto.gestao.repository;


import br.com.projeto.aeroporto.gestao.model.Bilhete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Bilhete}.
 *
 * <p>
 * Estende {@link JpaRepository}, fornecendo automaticamente operações básicas
 * de persistência (CRUD), além de suporte a paginação e ordenação para
 * objetos do tipo {@code Bilhete}.
 * </p>
 *
 * <p>
 * Esta interface atua como um <b>adapter</b> de infraestrutura em uma
 * arquitetura hexagonal (ports and adapters), podendo ser utilizada para
 * implementar a porta {@code BilheteRepositoryPort}, caso exista na aplicação.
 * </p>
 */
@Repository
public interface BilheteJpaRepository extends JpaRepository<Bilhete, Long> {
    // Métodos de consulta adicionais (query methods) podem ser declarados aqui, se necessário.
}