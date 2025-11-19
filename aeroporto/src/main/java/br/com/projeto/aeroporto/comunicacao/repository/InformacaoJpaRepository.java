package br.com.projeto.aeroporto.comunicacao.repository;


import br.com.projeto.aeroporto.comunicacao.model.Informacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Informacao}.
 *
 * <p>
 * Estende {@link JpaRepository}, fornecendo automaticamente operações básicas
 * de persistência (CRUD), além de suporte a paginação e ordenação para
 * objetos do tipo {@code Informacao}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface costuma
 * ser utilizada por um adapter (por exemplo, {@code InformacaoJpaAdapter})
 * para implementar a porta {@code InformacaoRepositoryPort}.
 * </p>
 */
@Repository
public interface InformacaoJpaRepository extends JpaRepository<Informacao, String> {
    // Métodos de consulta adicionais (query methods) podem ser declarados aqui, se necessário.
}