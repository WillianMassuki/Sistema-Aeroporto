package br.com.projeto.aeroporto.comunicacao.repository;


import br.com.projeto.aeroporto.comunicacao.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Funcionario}.
 *
 * <p>
 * Estende {@link JpaRepository}, fornecendo automaticamente operações básicas
 * de persistência (CRUD), além de suporte a paginação e ordenação para
 * objetos do tipo {@code Funcionario}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta interface costuma
 * ser utilizada por um adapter (por exemplo, {@code FuncionarioJpaAdapter})
 * para implementar a porta de saída {@code FuncionarioRepositoryOutPort}.
 * </p>
 */
@Repository
public interface FuncionarioJpaRepository extends JpaRepository<Funcionario, Long> {
    // Métodos de consulta adicionais (query methods) podem ser declarados aqui, se necessário.
}