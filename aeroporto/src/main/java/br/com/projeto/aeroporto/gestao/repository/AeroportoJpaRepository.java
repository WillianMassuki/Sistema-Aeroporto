package br.com.projeto.aeroporto.gestao.repository;


import br.com.projeto.aeroporto.gestao.model.Aeroporto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Aeroporto}.
 *
 * <p>
 * Estende {@link JpaRepository}, fornecendo automaticamente operações básicas
 * de persistência (CRUD), paginação e ordenação para {@code Aeroporto}.
 * </p>
 *
 * <p>
 * Esta interface é um <b>adapter</b> da camada de infraestrutura em uma
 * arquitetura hexagonal, implementando a persistência definida pela
 * {@code AeroportoRepositoryPort}, caso você a utilize.
 * </p>
 */
@Repository
public interface AeroportoJpaRepository extends JpaRepository<Aeroporto, Long> {
    // Métodos de consulta adicionais (query methods) podem ser declarados aqui, se necessário.
}