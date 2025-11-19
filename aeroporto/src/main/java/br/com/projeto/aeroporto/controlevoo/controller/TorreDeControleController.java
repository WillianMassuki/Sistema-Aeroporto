// adapter/inbound/controller/TorreDeControleController.java
package br.com.projeto.aeroporto.controlevoo.controller;


import br.com.projeto.aeroporto.controlevoo.model.TorreDeControle;
import br.com.projeto.aeroporto.controlevoo.service.TorreControleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por expor os endpoints relacionados
 * à entidade {@link TorreDeControle}.
 *
 * <p>
 * Esta classe recebe as requisições HTTP, delega a lógica de negócio
 * para o serviço {@link TorreControleService} e retorna as respostas
 * apropriadas para o cliente.
 * </p>
 *
 * <p>
 * Endpoints baseados no path: <b>/torres</b>
 * </p>
 */
@RestController
@RequestMapping("/torres")
public class TorreDeControleController {

    private final TorreControleService service;

    /**
     * Construtor da classe {@code TorreDeControleController}.
     *
     * @param torreDeControleUseCase serviço responsável pelas operações de
     *                               negócio envolvendo {@link TorreDeControle}
     */
    public TorreDeControleController(TorreControleService torreDeControleUseCase) {
        this.service = torreDeControleUseCase;
    }

    /**
     * Cria uma nova torre de controle.
     *
     * <p>
     * Requisição: {@code POST /torres}
     * </p>
     *
     * @param torre objeto {@link TorreDeControle} enviado no corpo da requisição
     * @return {@link ResponseEntity} contendo a {@link TorreDeControle} criada
     */
    @PostMapping
    public ResponseEntity<TorreDeControle> criar(@RequestBody TorreDeControle torre) {
        return ResponseEntity.ok(service.create(torre));
    }

    /**
     * Busca uma torre de controle pelo seu identificador.
     *
     * <p>
     * Requisição: {@code GET /torres/{id}}
     * </p>
     *
     * <p>
     * Retorna:
     * <ul>
     *   <li><b>200 OK</b> com o corpo contendo a torre, se encontrada;</li>
     *   <li><b>404 Not Found</b> se não houver torre com o ID informado.</li>
     * </ul>
     * </p>
     *
     * @param id identificador único da torre de controle
     * @return {@link ResponseEntity} com a torre encontrada ou status 404
     */
    @GetMapping("/{id}")
    public ResponseEntity<TorreDeControle> buscarPorId(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Lista todas as torres de controle cadastradas.
     *
     * <p>
     * Requisição: {@code GET /torres}
     * </p>
     *
     * @return lista de {@link TorreDeControle}
     */
    @GetMapping
    public List<TorreDeControle> listar() {
        return service.getAll();
    }

    /**
     * Remove uma torre de controle com base no seu identificador.
     *
     * <p>
     * Requisição: {@code DELETE /torres/{id}}
     * </p>
     *
     * @param id identificador da torre de controle a ser removida
     * @return {@link ResponseEntity} sem conteúdo (HTTP 204) em caso de sucesso
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
