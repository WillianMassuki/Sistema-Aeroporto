package br.com.projeto.aeroporto.controlevoo.out;


import br.com.projeto.aeroporto.controlevoo.model.TorreDeControle;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * Repositório para a entidade {@link TorreDeControle}.
 *
 * <p>
 * Esta interface define as operações básicas de persistência (CRUD) para
 * {@code TorreDeControle}. A implementação concreta pode utilizar JPA,
 * JDBC ou qualquer outra tecnologia de acesso a dados.
 * </p>
 *
 * <p>
 * A anotação {@link Repository} permite que o Spring gerencie a implementação
 * como um bean da camada de repositório, habilitando também o tratamento
 * automático de exceções de persistência.
 * </p>
 */
@Repository
public interface TorreDeControleRepository {

    /**
     * Salva uma torre de controle no repositório.
     *
     * <p>
     * Pode ser utilizada tanto para criação quanto para atualização de registros.
     * </p>
     *
     * @param torre objeto {@link TorreDeControle} a ser salvo
     * @return a {@link TorreDeControle} salva, possivelmente com ID gerado/atualizado
     */
    TorreDeControle save(TorreDeControle torre);

    /**
     * Busca uma torre de controle pelo seu identificador.
     *
     * @param id identificador único da torre de controle
     * @return um {@link Optional} contendo a {@link TorreDeControle} encontrada,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<TorreDeControle> findById(Long id);

    /**
     * Retorna todas as torres de controle armazenadas no repositório.
     *
     * @return lista contendo todas as instâncias de {@link TorreDeControle} persistidas
     */
    List<TorreDeControle> findAll();

    /**
     * Remove uma torre de controle do repositório com base no seu identificador.
     *
     * @param id identificador da torre de controle a ser removida
     */
    void deleteById(Long id);
}