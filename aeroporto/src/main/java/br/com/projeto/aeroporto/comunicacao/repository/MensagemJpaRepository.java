package br.com.projeto.aeroporto.comunicacao.repository;


import br.com.projeto.aeroporto.comunicacao.model.Mensagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Mensagem}.
 *
 * <p>
 * Estende {@link JpaRepository}, fornecendo automaticamente operações básicas
 * de persistência (CRUD), além de suporte a paginação e ordenação para
 * objetos do tipo {@code Mensagem}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface costuma
 * ser utilizada por um adapter (por exemplo, {@code MensagemJpaAdapter})
 * para implementar a porta {@code MensagemRepositoryPort}.
 * </p>
 */
@Repository
public interface MensagemJpaRepository extends JpaRepository<Mensagem, String> {
    // Métodos de consulta adicionais (query methods) podem ser declarados aqui, se necessário.
}