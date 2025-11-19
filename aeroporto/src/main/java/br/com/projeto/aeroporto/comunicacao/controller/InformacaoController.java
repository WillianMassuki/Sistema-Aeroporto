package br.com.projeto.aeroporto.comunicacao.controller;


import br.com.projeto.aeroporto.comunicacao.in.InformacaoUseCase;
import br.com.projeto.aeroporto.comunicacao.model.Informacao;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações sobre {@link Informacao}.
 *
 * <p>
 * Expõe endpoints HTTP para criação, consulta, listagem, atualização
 * e exclusão de informações. Toda a lógica de negócio é delegada ao
 * caso de uso {@link InformacaoUseCase}.
 * </p>
 *
 * <p>
 * Base path dos endpoints: {@code /api/informacoes}.
 * </p>
 */
@RestController
@RequestMapping("/api/informacoes")
public class InformacaoController {

    /**
     * Caso de uso responsável pelas operações de negócio relacionadas a {@link Informacao}.
     */
    private final InformacaoUseCase informacaoUseCase;

    /**
     * Construtor com injeção de dependência do caso de uso.
     *
     * @param informacaoUseCase implementação de {@link InformacaoUseCase}
     */
    public InformacaoController(InformacaoUseCase informacaoUseCase) {
        this.informacaoUseCase = informacaoUseCase;
    }

    /**
     * Cria uma nova informação.
     *
     * <p>
     * Endpoint: {@code POST /api/informacoes}
     * </p>
     *
     * @param informacao dados da informação a ser criada (JSON no corpo da requisição)
     * @return {@link ResponseEntity} contendo a informação criada e status HTTP 200 (OK)
     */
    @PostMapping
    @Operation(summary = "Adicionar uma informação nova")
    public ResponseEntity<Informacao> criar(@RequestBody Informacao informacao) {
        return ResponseEntity.ok(informacaoUseCase.criar(informacao));
    }

    /**
     * Busca uma informação pelo seu identificador.
     *
     * <p>
     * Endpoint: {@code GET /api/informacoes/{id}}
     * </p>
     *
     * @param id identificador da informação
     * @return {@link ResponseEntity} contendo a informação (status 200) se encontrada,
     *         ou status 404 (Not Found) caso contrário
     */
    @GetMapping("/{id}")
    @Operation(summary = "Filtrar a informação pelo codigo")
    public ResponseEntity<Informacao> buscarPorId(@PathVariable String id) {
        return informacaoUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Lista todas as informações cadastradas.
     *
     * <p>
     * Endpoint: {@code GET /api/informacoes}
     * </p>
     *
     * @return {@link ResponseEntity} contendo a lista de informações e status 200 (OK)
     */
    @GetMapping
    @Operation(summary = "Listar todas as informaçoes")
    public ResponseEntity<List<Informacao>> listar() {
        return ResponseEntity.ok(informacaoUseCase.listar());
    }

    /**
     * Atualiza os dados de uma informação existente.
     *
     * <p>
     * Endpoint: {@code PUT /api/informacoes/{id}}
     * </p>
     *
     * @param id         identificador da informação a ser atualizada
     * @param informacao objeto com os novos dados da informação
     * @return {@link ResponseEntity} contendo a informação atualizada (status 200)
     *         ou status 404 (Not Found) se a informação não existir
     */
    @PutMapping("/{id}")
    @Operation(summary = "atualizar os dados das informações")
    public ResponseEntity<Informacao> atualizar(@PathVariable String id, @RequestBody Informacao informacao) {
        try {
            Informacao atualizada = informacaoUseCase.atualizar(id, informacao);
            return ResponseEntity.ok(atualizada);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remove uma informação com base em seu identificador.
     *
     * <p>
     * Endpoint: {@code DELETE /api/informacoes/{id}}
     * </p>
     *
     * @param id identificador da informação a ser removida
     * @return {@link ResponseEntity} com status 204 (No Content) após a exclusão
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "deletar alguma informação")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
        informacaoUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}