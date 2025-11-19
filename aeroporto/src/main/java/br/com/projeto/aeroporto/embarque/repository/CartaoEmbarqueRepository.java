package br.com.projeto.aeroporto.embarque.repository;


import br.com.projeto.aeroporto.embarque.model.CartaoEmbarque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link CartaoEmbarque}.
 *
 * <p>
 * Esta interface estende {@link JpaRepository}, fornecendo operações CRUD
 * (criação, leitura, atualização e exclusão) e outras funcionalidades de
 * acesso a dados para a entidade {@code CartaoEmbarque}.
 * </p>
 *
 * <p>
 * Por ser uma interface do Spring Data JPA, não é necessário implementar
 * manualmente seus métodos: o Spring gera automaticamente a implementação
 * em tempo de execução.
 * </p>
 */
@Repository
public interface CartaoEmbarqueRepository extends JpaRepository<CartaoEmbarque, Long> {
    // Métodos de consulta customizados podem ser declarados aqui, se necessário.
}