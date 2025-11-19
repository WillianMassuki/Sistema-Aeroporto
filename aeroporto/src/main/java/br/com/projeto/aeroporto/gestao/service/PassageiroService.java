package br.com.projeto.aeroporto.gestao.service;


import br.com.projeto.aeroporto.gestao.in.PassageiroUseCase;
import br.com.projeto.aeroporto.gestao.model.Passageiro;
import br.com.projeto.aeroporto.gestao.out.PassageiroRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Serviço de aplicação para operações relacionadas a {@link Passageiro}.
 *
 * <p>
 * Implementa o caso de uso {@link PassageiroUseCase}, centralizando regras de negócio
 * e delegando o acesso a dados para a porta {@link PassageiroRepositoryPort}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe pertence
 * à camada de aplicação e normalmente é utilizada por controladores REST
 * ou outros componentes da camada de interface.
 * </p>
 */
@Service
public class PassageiroService implements PassageiroUseCase {

    /**
     * Porta de repositório responsável pelo acesso aos dados de {@link Passageiro}.
     */
    private final PassageiroRepositoryPort repository;

    /**
     * Construtor que recebe a dependência de repositório via injeção.
     *
     * @param repository implementação de {@link PassageiroRepositoryPort}
     *                   utilizada para persistência dos dados de passageiros
     */
    public PassageiroService(PassageiroRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Salva um novo passageiro ou atualiza um já existente.
     *
     * @param passageiro objeto contendo os dados do passageiro a ser salvo
     * @return o passageiro persistido
     */
    @Override
    public Passageiro salvar(Passageiro passageiro) {
        return repository.salvar(passageiro);
    }

    /**
     * Retorna a lista de todos os passageiros cadastrados.
     *
     * @return lista de {@link Passageiro}
     */
    @Override
    public List<Passageiro> listar() {
        return repository.listar();
    }

    /**
     * Busca um passageiro pelo seu identificador.
     *
     * <p>
     * Diferentemente das outras services, aqui o repositório retorna diretamente
     * o {@code Passageiro} (não um {@code Optional}), portanto a responsabilidade
     * de tratar "não encontrado" fica na implementação do repositório.
     * </p>
     *
     * @param id identificador do passageiro
     * @return passageiro correspondente ao ID informado
     */
    @Override
    public Passageiro buscarPorId(Long id) {
        return repository.buscarPorId(id);
    }

    /**
     * Atualiza os dados de um passageiro existente.
     *
     * @param id    identificador do passageiro a ser atualizado
     * @param novo  objeto contendo os novos dados do passageiro
     * @return passageiro atualizado e persistido
     */
    @Override
    public Passageiro atualizar(Long id, Passageiro novo) {
        Passageiro atual = buscarPorId(id);
        atual.setNome(novo.getNome());
        atual.setDocumento(novo.getDocumento());
        atual.setNumeroCartao(novo.getNumeroCartao());
        return repository.salvar(atual);
    }

    /**
     * Remove um passageiro com base em seu identificador.
     *
     * @param id identificador do passageiro a ser removido
     */
    @Override
    public void deletar(Long id) {
        repository.deletar(id);
    }
}