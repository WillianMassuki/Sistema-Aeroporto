package br.com.projeto.aeroporto.gestao.service;


import br.com.projeto.aeroporto.gestao.in.BilheteUseCase;
import br.com.projeto.aeroporto.gestao.model.Bilhete;
import br.com.projeto.aeroporto.gestao.out.BilheteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço de aplicação para operações relacionadas a {@link Bilhete}.
 *
 * <p>
 * Implementa o caso de uso {@link BilheteUseCase}, centralizando regras de negócio
 * e delegando o acesso a dados para a porta {@link BilheteRepositoryPort}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe pertence
 * à camada de aplicação e pode ser utilizada, por exemplo, por controladores REST.
 * </p>
 */
@Service
public class BilheteService implements BilheteUseCase {

    /**
     * Porta de repositório responsável pelo acesso aos dados de {@link Bilhete}.
     */
    private final BilheteRepositoryPort repository;

    /**
     * Construtor que recebe a dependência de repositório via injeção.
     *
     * @param repository implementação de {@link BilheteRepositoryPort}
     *                   utilizada para persistência dos dados de bilhetes
     */
    public BilheteService(BilheteRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Salva um novo bilhete ou atualiza um já existente.
     *
     * @param bilhete objeto contendo os dados do bilhete a ser salvo
     * @return o bilhete persistido
     */
    @Override
    public Bilhete salvar(Bilhete bilhete) {
        return repository.salvar(bilhete);
    }

    /**
     * Retorna a lista de todos os bilhetes cadastrados.
     *
     * @return lista de {@link Bilhete}
     */
    @Override
    public List<Bilhete> listar() {
        return repository.listar();
    }

    /**
     * Busca um bilhete pelo seu identificador.
     *
     * @param id identificador do bilhete
     * @return bilhete correspondente ao ID informado
     * @throws RuntimeException caso o bilhete não seja encontrado
     */
    @Override
    public Bilhete buscarPorId(Long id) {
        return repository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Bilhete não encontrado"));
    }

    /**
     * Atualiza os dados de um bilhete existente.
     *
     * <p>
     * Atualmente são atualizados o assento e o número do bilhete.
     * As atualizações de bagagem e passageiro estão comentadas e podem ser
     * habilitadas futuramente, conforme as regras de negócio.
     * </p>
     *
     * @param id   identificador do bilhete a ser atualizado
     * @param novo objeto contendo os novos dados do bilhete
     * @return bilhete atualizado e persistido
     * @throws RuntimeException caso o bilhete não seja encontrado
     */
    @Override
    public Bilhete atualizar(Long id, Bilhete novo) {
        Bilhete atual = buscarPorId(id);
        atual.setAssento(novo.getAssento());
        // atual.setBagagem(novo.getBagagem());
        atual.setNumero(novo.getNumero());
        // atual.setPassageiro(novo.getPassageiro());
        return repository.salvar(atual);
    }

    /**
     * Remove um bilhete com base em seu identificador.
     *
     * @param id identificador do bilhete a ser removido
     */
    @Override
    public void deletar(Long id) {
        repository.deletar(id);
    }
}