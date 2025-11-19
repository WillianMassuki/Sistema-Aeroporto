package br.com.projeto.aeroporto.controlevoo.adapter;


import br.com.projeto.aeroporto.controlevoo.model.Controlador;
import br.com.projeto.aeroporto.controlevoo.out.ControladorRepositoryPort;
import br.com.projeto.aeroporto.controlevoo.repository.ControladorJpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Adapter responsável por implementar a porta {@link ControladorRepositoryPort}
 * utilizando o repositório JPA {@link ControladorJpaRepository}.
 *
 * <p>
 * Esta classe faz a ponte entre a camada de domínio e a camada de persistência,
 * seguindo o padrão de arquitetura Hexagonal (Ports and Adapters).
 * O domínio depende apenas da interface (porta), enquanto este adapter cuida
 * dos detalhes de acesso ao banco de dados.
 * </p>
 */
@Component
public class ControladorRepositoryAdapter implements ControladorRepositoryPort {

    private final ControladorJpaRepository controladorJpaRepository;

    /**
     * Construtor da classe {@code ControladorRepositoryAdapter}.
     *
     * @param controladorJpaRepository repositório JPA responsável pelo acesso aos dados
     *                                 da entidade {@link Controlador}
     */
    public ControladorRepositoryAdapter(ControladorJpaRepository controladorJpaRepository) {
        this.controladorJpaRepository = controladorJpaRepository;
    }

    /**
     * Salva um {@link Controlador} no banco de dados.
     *
     * <p>
     * Pode ser utilizado tanto para criar um novo registro quanto para atualizar
     * um registro existente.
     * </p>
     *
     * @param controlador entidade {@link Controlador} a ser salva
     * @return o {@link Controlador} salvo, possivelmente com ID gerado/atualizado
     */
    @Override
    public Controlador save(Controlador controlador) {
        return controladorJpaRepository.save(controlador);
    }

    /**
     * Busca um {@link Controlador} pelo seu identificador.
     *
     * @param id identificador único do controlador
     * @return um {@link Optional} contendo o {@link Controlador} encontrado,
     *         ou vazio caso não exista registro com o ID informado
     */
    @Override
    public Optional<Controlador> findById(Long id) {
        return controladorJpaRepository.findById(id);
    }

    /**
     * Retorna todos os controladores cadastrados no banco de dados.
     *
     * @return lista contendo todas as instâncias de {@link Controlador} persistidas
     */
    @Override
    public List<Controlador> findAll() {
        return controladorJpaRepository.findAll();
    }

    /**
     * Remove um {@link Controlador} do banco de dados com base no seu identificador.
     *
     * @param id identificador do controlador a ser removido
     */
    @Override
    public void deleteById(Long id) {
        controladorJpaRepository.deleteById(id);
    }
}
