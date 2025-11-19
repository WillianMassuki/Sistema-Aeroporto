package br.com.projeto.aeroporto.comunicacao.controller;


import br.com.projeto.aeroporto.comunicacao.in.MensagemUseCase;
import br.com.projeto.aeroporto.comunicacao.model.Mensagem;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações sobre {@link Mensagem}.
 *
 * <p>
 * Expõe endpoints HTTP para criação, consulta, listagem, atualização
 * e exclusão de mensagens. Toda a lógica de negócio é delegada ao
 * caso de uso {@link MensagemUseCase}.
 * </p>
 *
 * <p>
 * Base path dos endpoints: {@code /api/mensagens}.
 * </p>
 */
@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {

    /**
     * Caso de uso responsável pelas operações de negócio relacionadas a {@link Mensagem}.
     */
    private final MensagemUseCase mensagemUseCase;

    /**
     * Construtor com injeção de dependência do caso de uso.
     *
     * @param mensagemUseCase implementação de {@link MensagemUseCase}
     */
    public MensagemController(MensagemUseCase mensagemUseCase) {
        this.mensagemUseCase = mensagemUseCase;
    }

    /**
     * Cria uma nova mensagem.
     *
     * <p>
     * Endpoint: {@code POST /api/mensagens}
     * </p>
     *
     * @param mensagem dados da mensagem a ser criada (JSON no corpo da requisição)
     * @return {@link ResponseEntity} contendo a mensagem criada e status HTTP 200 (OK)
     */
    @PostMapping
    public ResponseEntity<Mensagem> criar(@RequestBody Mensagem mensagem) {
        return ResponseEntity.ok(mensagemUseCase.criar(mensagem));
    }

    /**
     * Busca uma mensagem pelo seu identificador.
     *
     * <p>
     * Endpoint: {@code GET /api/mensagens/{id}}
     * </p>
     *
     * @param id identificador da mensagem
     * @return {@link ResponseEntity} contendo a mensagem (status 200) se encontrada,
     *         ou status 404 (Not Found) caso contrário
     */
    @GetMapping("/{id}")
    public ResponseEntity<Mensagem> buscarPorId(@PathVariable String id) {
        return mensagemUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Lista todas as mensagens cadastradas.
     *
     * <p>
     * Endpoint: {@code GET /api/mensagens}
     * </p>
     *
     * @return {@link ResponseEntity} contendo a lista de mensagens e status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Mensagem>> listar() {
        return ResponseEntity.ok(mensagemUseCase.listar());
    }

    /**
     * Atualiza os dados de uma mensagem existente.
     *
     * <p>
     * Endpoint: {@code PUT /api/mensagens/{id}}
     * </p>
     *
     * @param id       identificador da mensagem a ser atualizada
     * @param mensagem objeto com os novos dados da mensagem
     * @return {@link ResponseEntity} contendo a mensagem atualizada (status 200)
     *         ou status 404 (Not Found) se a mensagem não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Mensagem> atualizar(@PathVariable String id, @RequestBody Mensagem mensagem) {
        try {
            Mensagem atualizada = mensagemUseCase.atualizar(id, mensagem);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remove uma mensagem com base em seu identificador.
     *
     * <p>
     * Endpoint: {@code DELETE /api/mensagens/{id}}
     * </p>
     *
     * @param id identificador da mensagem a ser removida
     * @return {@link ResponseEntity} com status 204 (No Content) após a exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        mensagemUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}