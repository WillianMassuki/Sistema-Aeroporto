package br.com.projeto.aeroporto.embarque.service;


import br.com.projeto.aeroporto.embarque.in.BagagemUseCase;
import br.com.projeto.aeroporto.embarque.model.Bagagem;
import br.com.projeto.aeroporto.embarque.out.BagagemRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço responsável pelas regras de negócio relacionadas à entidade {@link Bagagem}.
 *
 * <p>
 * Implementa o caso de uso {@link BagagemUseCase} e utiliza a porta
 * {@link BagagemRepositoryPort} para acesso ao repositório, mantendo o domínio
 * desacoplado de detalhes de persistência.
 * </p>
 */
@Service
public class BagagemService implements BagagemUseCase {

    private final BagagemRepositoryPort repository;

    /**
     * Construtor da classe {@code BagagemService}.
     *
     * @param repository porta de acesso ao repositório de {@link Bagagem}
     */
    public BagagemService(BagagemRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Cria ou atualiza uma bagagem.
     *
     * @param bagagem objeto {@link Bagagem} a ser salvo
     * @return a {@link Bagagem} salva, possivelmente com ID gerado/atualizado
     */
    @Override
    public Bagagem salvar(Bagagem bagagem) {
        return repository.salvar(bagagem);
    }

    /**
     * Lista todas as bagagens cadastradas.
     *
     * @return lista contendo todas as {@link Bagagem} persistidas
     */
    @Override
    public List<Bagagem> listar() {
        return repository.listar();
    }

    /**
     * Busca uma bagagem pelo seu identificador.
     *
     * @param id identificador único da bagagem
     * @return a {@link Bagagem} correspondente ao ID informado
     * @throws RuntimeException caso nenhuma bagagem seja encontrada para o ID informado
     */
    @Override
    public Bagagem buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Bagagem não encontrada"));
    }

    /**
     * Atualiza os dados de uma bagagem existente.
     *
     * <p>
     * Primeiro busca a bagagem pelo ID; em seguida, altera os campos
     * {@code peso} e {@code nome} com base nos dados da nova bagagem
     * informada e salva novamente no repositório.
     * </p>
     *
     * @param id          identificador da bagagem a ser atualizada
     * @param novaBagagem objeto {@link Bagagem} contendo os novos dados
     * @return a {@link Bagagem} atualizada
     * @throws RuntimeException caso a bagagem não seja encontrada
     */
    @Override
    public Bagagem atualizar(Long id, Bagagem novaBagagem) {
        Bagagem existente = buscarPorId(id);
        existente.setPeso(novaBagagem.getPeso());
        existente.setNome(novaBagagem.getNome());
        return repository.salvar(existente);
    }

    /**
     * Remove uma bagagem com base no seu identificador.
     *
     * @param id identificador da bagagem a ser removida
     */
    @Override
    public void deletar(Long id) {
        repository.deletar(id);
    }
}