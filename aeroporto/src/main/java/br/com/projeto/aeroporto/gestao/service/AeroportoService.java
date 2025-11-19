package br.com.projeto.aeroporto.gestao.service;


import br.com.projeto.aeroporto.gestao.in.AeroportoUseCase;
import br.com.projeto.aeroporto.gestao.model.Aeroporto;
import br.com.projeto.aeroporto.gestao.out.AeroportoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço de aplicação para operações relacionadas a {@link Aeroporto}.
 *
 * <p>
 * Implementa o caso de uso {@link AeroportoUseCase}, orquestrando as regras
 * de negócio e delegando a persistência para a porta
 * {@link AeroportoRepositoryPort}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal, esta classe faz parte da camada de aplicação,
 * consumindo a port de repositório e podendo ser utilizada por controladores
 * REST, por exemplo.
 * </p>
 */
@Service
public class AeroportoService implements AeroportoUseCase {

    /**
     * Porta de repositório responsável pelo acesso aos dados de {@link Aeroporto}.
     */
    private final AeroportoRepositoryPort repository;

    /**
     * Construtor que recebe a dependência de repositório via injeção.
     *
     * @param repository implementação de {@link AeroportoRepositoryPort}
     *                   utilizada para persistência dos dados
     */
    public AeroportoService(AeroportoRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Salva um novo aeroporto ou atualiza um já existente.
     *
     * @param aeroporto objeto contendo os dados do aeroporto a ser salvo
     * @return o aeroporto persistido
     */
    @Override
    public Aeroporto salvar(Aeroporto aeroporto) {
        return repository.salvar(aeroporto);
    }

    /**
     * Retorna a lista de todos os aeroportos cadastrados.
     *
     * @return lista de {@link Aeroporto}
     */
    @Override
    public List<Aeroporto> listar() {
        return repository.listar();
    }

    /**
     * Busca um aeroporto pelo seu identificador.
     *
     * @param id identificador do aeroporto
     * @return aeroporto correspondente ao ID informado
     * @throws RuntimeException caso o aeroporto não seja encontrado
     */
    @Override
    public Aeroporto buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Aeroporto não encontrado"));
    }

    /**
     * Atualiza os dados de um aeroporto existente.
     *
     * @param id   identificador do aeroporto a ser atualizado
     * @param novo objeto contendo os novos dados do aeroporto
     * @return aeroporto atualizado e persistido
     * @throws RuntimeException caso o aeroporto não seja encontrado
     */
    @Override
    public Aeroporto atualizar(Long id, Aeroporto novo) {
        Aeroporto atual = buscarPorId(id);
        atual.setNome(novo.getNome());
        atual.setCodigo(novo.getCodigo());
        return repository.salvar(atual);
    }

    /**
     * Remove um aeroporto com base em seu identificador.
     *
     * @param id identificador do aeroporto a ser removido
     */
    @Override
    public void deletar(Long id) {
        repository.deletar(id);
    }

    /**
     * Realiza operações de gestão de funcionários do aeroporto.
     *
     * <p>
     * Método ainda não implementado. No futuro, pode conter lógica
     * relacionada à administração de funcionários vinculados ao aeroporto.
     * </p>
     */
    public void gerenciarFuncionarios() {
        // Implementação futura da gestão de funcionários.
    }
}