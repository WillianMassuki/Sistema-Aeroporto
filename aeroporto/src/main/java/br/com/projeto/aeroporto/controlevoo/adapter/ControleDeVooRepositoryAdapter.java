package br.com.project.airport.controlevoo.adapter;


import br.com.projeto.aeroporto.controlevoo.model.ControleDeVoo;
import br.com.projeto.aeroporto.controlevoo.port.ControleDeVooRepositoryPort;
import br.com.projeto.aeroporto.controlevoo.repository.ControladorVooJPARepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Adapter responsável por implementar a porta {@link ControleDeVooRepositoryPort}
 * utilizando o repositório JPA {@link ControladorVooJPARepository}.
 *
 * <p>
 * Esta classe faz a ponte entre a camada de domínio e a camada de persistência,
 * seguindo o padrão de arquitetura Hexagonal (Ports and Adapters).
 * O domínio conhece apenas a interface ({@link ControleDeVooRepositoryPort}),
 * enquanto este adapter cuida dos detalhes de acesso ao banco de dados.
 * </p>
 */
@Component
public class ControleDeVooRepositoryAdapter implements ControleDeVooRepositoryPort {

    private final ControladorVooJPARepository jpaRepository;

    /**
     * Construtor da classe {@code ControleDeVooRepositoryAdapter}.
     *
     * @param jpaRepository repositório JPA responsável pelo acesso aos dados
     *                      da entidade {@link ControleDeVoo}
     */
    public ControleDeVooRepositoryAdapter(ControladorVooJPARepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    /**
     * Salva uma instância de {@link ControleDeVoo} no banco de dados.
     *
     * <p>
     * Pode ser utilizado tanto para criar um novo registro quanto para
     * atualizar um registro existente.
     * </p>
     *
     * @param controle entidade {@link ControleDeVoo} a ser salva
     * @return o {@link ControleDeVoo} salvo, possivelmente com ID gerado/atualizado
     */
    @Override
    public ControleDeVoo save(ControleDeVoo controle) {
        return jpaRepository.save(controle);
    }

    /**
     * Busca um {@link ControleDeVoo} pelo seu identificador.
     *
     * @param id identificador único do controle de voo
     * @return um {@link Optional} contendo o {@link ControleDeVoo} encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    @Override
    public Optional<ControleDeVoo> findById(Long id) {
        return jpaRepository.findById(id);
    }

    /**
     * Retorna todos os registros de controle de voo cadastrados.
     *
     * @return lista contendo todas as instâncias de {@link ControleDeVoo} persistidas
     */
    @Override
    public List<ControleDeVoo> findAll() {
        return jpaRepository.findAll();
    }

    /**
     * Remove um registro de {@link ControleDeVoo} com base no seu identificador.
     *
     * @param id identificador do controle de voo a ser removido
     */
    @Override
    public void deleteById(Long id) {
        jpaRepository.deleteById(id);
    }
}