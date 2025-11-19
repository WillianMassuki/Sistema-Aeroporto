package br.com.projeto.aeroporto.embarque.out;


import br.com.projeto.aeroporto.embarque.model.Bagagem;

import java.util.List;
import java.util.Optional;

/**
 * Porta (interface) de acesso ao repositório de {@link Bagagem}.
 *
 * <p>
 * Define o contrato que a camada de infraestrutura deve implementar para
 * realizar operações de persistência de bagagens, mantendo o domínio desacoplado
 * de detalhes específicos de banco de dados ou tecnologia.
 * </p>
 */
public interface BagagemRepositoryPort {

    /**
     * Salva uma bagagem no repositório.
     *
     * <p>
     * Pode ser utilizada tanto para criação quanto para atualização de registros.
     * </p>
     *
     * @param bagagem objeto {@link Bagagem} a ser salvo
     * @return a {@link Bagagem} salva, possivelmente com ID gerado/atualizado
     */
    Bagagem salvar(Bagagem bagagem);

    /**
     * Retorna todas as bagagens armazenadas no repositório.
     *
     * @return lista contendo todas as {@link Bagagem} persistidas
     */
    List<Bagagem> listar();

    /**
     * Busca uma bagagem pelo seu identificador.
     *
     * @param id identificador único da bagagem
     * @return um {@link Optional} contendo a {@link Bagagem} encontrada,
     *         ou vazio caso não exista registro com o ID informado
     */
    Optional<Bagagem> buscarPorId(Long id);

    /**
     * Remove uma bagagem do repositório com base no seu identificador.
     *
     * @param id identificador da bagagem a ser removida
     */
    void deletar(Long id);
}