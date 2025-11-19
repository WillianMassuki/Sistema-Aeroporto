package br.com.projeto.aeroporto.embarque.repository;


import br.com.projeto.aeroporto.embarque.model.Bagagem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Bagagem}.
 *
 * <p>
 * Esta interface estende {@link JpaRepository}, fornecendo operações CRUD
 * prontas (criação, leitura, atualização e exclusão) e outras funcionalidades
 * de acesso a dados para a entidade {@code Bagagem}.
 * </p>
 *
 * <p>
 * Por ser uma interface do Spring Data JPA, não é necessário implementar
 * manualmente seus métodos: o Spring gera automaticamente a implementação
 * em tempo de execução.
 * </p>
 */
@Repository
public interface BagagemJpaRepository extends JpaRepository<Bagagem, Long> {
    // Métodos de consulta customizados podem ser declarados aqui, se necessário.
}
