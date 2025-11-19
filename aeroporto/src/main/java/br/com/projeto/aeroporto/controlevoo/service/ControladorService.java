package br.com.projeto.aeroporto.controlevoo.service;


import br.com.projeto.aeroporto.controlevoo.in.ControladorUseCase;
import br.com.projeto.aeroporto.controlevoo.model.Controlador;
import br.com.projeto.aeroporto.controlevoo.out.ControladorRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pelas regras de negócio relacionadas à entidade {@link Controlador}.
 *
 * <p>
 * Implementa o caso de uso {@link ControladorUseCase} e utiliza a porta
 * {@link ControladorRepositoryPort} para acesso ao repositório, mantendo
 * a camada de domínio desacoplada dos detalhes de persistência.
 * </p>
 */
@Service
public class ControladorService implements ControladorUseCase {

    private final ControladorRepositoryPort repository;

    /**
     * Construtor da classe {@code ControladorService}.
     *
     * @param repository porta de acesso ao repositório de {@link Controlador}
     */
    public ControladorService(ControladorRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Cria um novo controlador.
     *
     * @param controlador objeto {@link Controlador} a ser criado
     * @return o {@link Controlador} criado e persistido
     */
    @Override
    public Controlador create(Controlador controlador) {
        return repository.save(controlador);
    }

    /**
     * Atualiza os dados de um controlador existente.
     *
     * <p>
     * Primeiro busca o controlador pelo ID; caso não exista, lança uma exceção.
     * Em seguida, atualiza os campos {@code nome} e {@code matricula} com base
     * nos dados recebidos e persiste novamente a entidade.
     * </p>
     *
     * @param id          identificador do controlador a ser atualizado
     * @param controlador objeto {@link Controlador} contendo os novos dados
     * @return o {@link Controlador} atualizado
     * @throws RuntimeException caso o controlador não seja encontrado
     */
    @Override
    public Controlador update(Long id, Controlador controlador) {
        Controlador existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controlador não encontrado"));

        existente.setNome(controlador.getNome());
        existente.setMatricula(controlador.getMatricula());

        return repository.save(existente);
    }

    /**
     * Busca um controlador pelo seu identificador.
     *
     * @param id identificador único do controlador
     * @return o {@link Controlador} correspondente ao ID informado
     * @throws RuntimeException caso o controlador não seja encontrado
     */
    @Override
    public Controlador getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Controlador não encontrado"));
    }

    /**
     * Retorna todos os controladores cadastrados.
     *
     * @return lista contendo todas as instâncias de {@link Controlador} persistidas
     */
    @Override
    public List<Controlador> getAll() {
        return repository.findAll();
    }

    /**
     * Remove um controlador com base no seu identificador.
     *
     * @param id identificador do controlador a ser removido
     */
    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    /**
     * Método placeholder para lógica de monitoramento de voo.
     *
     * <p>
     * Atualmente não possui implementação e retorna {@code null}.
     * Pode ser utilizado futuramente para implementar funcionalidades
     * de monitoramento de voos associadas a um controlador.
     * </p>
     *
     * @return sempre {@code null}, até que seja implementado
     */
    public Void monitorarVoo() {
        return null;
    }

}
