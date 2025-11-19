package br.com.projeto.aeroporto.controlevoo.repository;


import br.com.projeto.aeroporto.controlevoo.model.Controlador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório JPA para a entidade {@link Controlador}.
 *
 * <p>
 * Esta interface estende {@link JpaRepository}, fornecendo operações
 * CRUD (criação, leitura, atualização e exclusão) e outras funcionalidades
 * de acesso a dados para a entidade {@code Controlador}.
 * </p>
 *
 * <p>
 * Por ser uma interface do Spring Data JPA, o Spring gera automaticamente
 * a implementação em tempo de execução, não sendo necessário implementar
 * os métodos manualmente.
 * </p>
 */
@Repository
public interface ControladorJpaRepository extends JpaRepository<Controlador, Long> {
    // Métodos de consulta customizados podem ser adicionados aqui, se necessário.
}