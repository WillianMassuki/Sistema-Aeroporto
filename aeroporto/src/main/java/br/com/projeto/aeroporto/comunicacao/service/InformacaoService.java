package br.com.projeto.aeroporto.comunicacao.service;


import br.com.projeto.aeroporto.comunicacao.in.InformacaoUseCase;
import br.com.projeto.aeroporto.comunicacao.model.Informacao;
import br.com.projeto.aeroporto.comunicacao.out.InformacaoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço de aplicação para operações relacionadas a {@link Informacao}.
 *
 * <p>
 * Implementa o caso de uso {@link InformacaoUseCase}, centralizando as regras
 * de negócio e delegando o acesso a dados para a porta {@link InformacaoRepositoryPort}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe pertence
 * à camada de aplicação e é normalmente utilizada por controladores REST
 * ou outros componentes de interface.
 * </p>
 */
@Service
public class InformacaoService implements InformacaoUseCase {

    /**
     * Porta de repositório responsável pelo acesso aos dados de {@link Informacao}.
     */
    private final InformacaoRepositoryPort repository;

    /**
     * Construtor com injeção de dependência do repositório.
     *
     * @param repository implementação de {@link InformacaoRepositoryPort}
     *                   usada para persistência das informações
     */
    public InformacaoService(InformacaoRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Cria uma nova informação.
     *
     * <p>
     * Delegado ao método {@link InformacaoRepositoryPort#salvar(Informacao)}.
     * </p>
     *
     * @param informacao objeto contendo os dados da informação a ser criada
     * @return informação persistida
     */
    @Override
    public Informacao criar(Informacao informacao) {
        return repository.salvar(informacao);
    }

    /**
     * Busca uma informação pelo seu identificador.
     *
     * @param id identificador da informação
     * @return um {@link Optional} contendo a informação, caso encontrada;
     *         vazio caso contrário
     */
    @Override
    public Optional<Informacao> buscarPorId(String id) {
        return repository.buscarPorId(id);
    }

    /**
     * Lista todas as informações cadastradas.
     *
     * @return lista de informações
     */
    @Override
    public List<Informacao> listar() {
        return repository.buscarTodos();
    }

    /**
     * Atualiza os dados de uma informação existente.
     *
     * <p>
     * Primeiro busca a informação pelo ID; se existir, atualiza seus campos
     * (tipo e validade) e persiste novamente. Caso não seja encontrada,
     * lança uma {@link RuntimeException}.
     * </p>
     *
     * @param id         identificador da informação a ser atualizada
     * @param informacao objeto contendo os novos dados da informação
     * @return informação atualizada e persistida
     * @throws RuntimeException caso a informação não seja encontrada
     */
    @Override
    public Informacao atualizar(String id, Informacao informacao) {
        Optional<Informacao> existente = repository.buscarPorId(id);
        if (existente.isPresent()) {
            Informacao atualizada = existente.get();
            atualizada.setTipo(informacao.getTipo());
            atualizada.setValidade(informacao.getValidade());
            return repository.salvar(atualizada);
        } else {
            throw new RuntimeException("Informação não encontrada");
        }
    }

    /**
     * Remove uma informação com base em seu identificador.
     *
     * @param id identificador da informação a ser removida
     */
    @Override
    public void deletar(String id) {
        repository.deletarPorId(id);
    }
}