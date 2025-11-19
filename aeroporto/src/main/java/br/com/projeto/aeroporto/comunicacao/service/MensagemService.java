package br.com.projeto.aeroporto.comunicacao.service;

import br.com.projeto.aeroporto.comunicacao.in.MensagemUseCase;
import br.com.projeto.aeroporto.comunicacao.model.Mensagem;
import br.com.projeto.aeroporto.comunicacao.out.MensagemRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Serviço de aplicação para operações relacionadas a {@link Mensagem}.
 *
 * <p>
 * Implementa o caso de uso {@link MensagemUseCase}, centralizando as regras
 * de negócio e delegando o acesso a dados para a porta {@link MensagemRepositoryPort}.
 * </p>
 *
 * <p>
 * Em uma arquitetura hexagonal (ports and adapters), esta classe pertence
 * à camada de aplicação e é normalmente utilizada por controladores REST
 * ou outros componentes de interface.
 * </p>
 */
@Service
public class MensagemService implements MensagemUseCase {

    /**
     * Porta de repositório responsável pelo acesso aos dados de {@link Mensagem}.
     */
    private final MensagemRepositoryPort repository;

    /**
     * Construtor com injeção de dependência do repositório.
     *
     * @param repository implementação de {@link MensagemRepositoryPort}
     *                   usada para persistência das mensagens
     */
    public MensagemService(MensagemRepositoryPort repository) {
        this.repository = repository;
    }

    /**
     * Cria uma nova mensagem.
     *
     * <p>
     * Delegado ao método {@link MensagemRepositoryPort#salvar(Mensagem)}.
     * </p>
     *
     * @param mensagem objeto contendo os dados da mensagem a ser criada
     * @return mensagem persistida
     */
    @Override
    public Mensagem criar(Mensagem mensagem) {
        return repository.salvar(mensagem);
    }

    /**
     * Busca uma mensagem pelo seu identificador.
     *
     * @param id identificador da mensagem
     * @return um {@link Optional} contendo a mensagem, caso encontrada;
     *         vazio caso contrário
     */
    @Override
    public Optional<Mensagem> buscarPorId(String id) {
        return repository.buscarPorId(id);
    }

    /**
     * Lista todas as mensagens cadastradas.
     *
     * @return lista de mensagens
     */
    @Override
    public List<Mensagem> listar() {
        return repository.buscarTodos();
    }

    /**
     * Atualiza os dados de uma mensagem existente.
     *
     * <p>
     * Primeiro busca a mensagem pelo ID; se existir, atualiza seus campos
     * (remetente, destinatário, conteúdo e data/hora) e persiste novamente.
     * Caso não seja encontrada, lança uma {@link RuntimeException}.
     * </p>
     *
     * @param id       identificador da mensagem a ser atualizada
     * @param mensagem objeto contendo os novos dados da mensagem
     * @return mensagem atualizada e persistida
     * @throws RuntimeException caso a mensagem não seja encontrada
     */
    @Override
    public Mensagem atualizar(String id, Mensagem mensagem) {
        Optional<Mensagem> existente = repository.buscarPorId(id);
        if (existente.isPresent()) {
            Mensagem atualizada = existente.get();
            atualizada.setRemetente(mensagem.getRemetente());
            atualizada.setDestinatario(mensagem.getDestinatario());
            atualizada.setConteudo(mensagem.getConteudo());
            atualizada.setDataHora(mensagem.getDataHora());
            return repository.salvar(atualizada);
        } else {
            throw new RuntimeException("Mensagem não encontrada");
        }
    }

    /**
     * Remove uma mensagem com base em seu identificador.
     *
     * @param id identificador da mensagem a ser removida
     */
    @Override
    public void deletar(String id) {
        repository.deletarPorId(id);
    }
}
