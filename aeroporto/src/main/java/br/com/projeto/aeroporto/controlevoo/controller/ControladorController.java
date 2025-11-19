package br.com.projeto.aeroporto.controlevoo.controller;


import br.com.projeto.aeroporto.controlevoo.in.ControladorUseCase;
import br.com.projeto.aeroporto.controlevoo.model.Controlador;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por expor os endpoints da entidade {@link Controlador}.
 *
 * <p>
 * Esta classe recebe as requisições HTTP, delega a lógica de negócio para o
 * caso de uso {@link ControladorUseCase} e devolve as respostas apropriadas
 * usando {@link ResponseEntity}.
 * </p>
 *
 * <p>
 * Endpoints baseados no path: <b>/controladores</b>
 * </p>
 */
@RestController
@RequestMapping("/controladores")
public class ControladorController {

    private final ControladorUseCase service;

    /**
     * Construtor da classe {@code ControladorController}.
     *
     * @param service caso de uso responsável pelas operações de negócio
     *                envolvendo {@link Controlador}
     */
    public ControladorController(ControladorUseCase service) {
        this.service = service;
    }

    /**
     * Cria um novo controlador.
     *
     * <p>
     * Requisição: {@code POST /controladores}
     * </p>
     *
     * @param controlador objeto {@link Controlador} enviado no corpo da requisição
     * @return {@link ResponseEntity} contendo o {@link Controlador} criado
     */
    @PostMapping
    @Operation(summary = "Criação do controlador")
    public ResponseEntity<Controlador> create(@RequestBody Controlador controlador) {
        return ResponseEntity.ok(service.create(controlador));
    }

    /**
     * Lista todos os controladores cadastrados.
     *
     * <p>
     * Requisição: {@code GET /controladores}
     * </p>
     *
     * @return {@link ResponseEntity} contendo a lista de {@link Controlador}
     */
    @GetMapping
    @Operation(summary = "Lista todos os controladores")
    public ResponseEntity<List<Controlador>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    /**
     * Busca um controlador pelo seu identificador.
     *
     * <p>
     * Requisição: {@code GET /controladores/{id}}
     * </p>
     *
     * @param id identificador único do controlador
     * @return {@link ResponseEntity} contendo o {@link Controlador} encontrado
     * @throws RuntimeException (ou exceção específica) se o controlador não for encontrado,
     *                          a depender da implementação de {@link ControladorUseCase}
     */
    @GetMapping("/{id}")
    @Operation(summary = "Busca um controlador por ID")
    public ResponseEntity<Controlador> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    /**
     * Atualiza os dados de um controlador existente.
     *
     * <p>
     * Requisição: {@code PUT /controladores/{id}}
     * </p>
     *
     * @param id          identificador do controlador a ser atualizado
     * @param controlador objeto {@link Controlador} com os novos dados
     * @return {@link ResponseEntity} contendo o {@link Controlador} atualizado
     */
    @PutMapping("/{id}")
    @Operation(summary = "Atualiza um controlador existente")
    public ResponseEntity<Controlador> update(@PathVariable Long id, @RequestBody Controlador controlador) {
        return ResponseEntity.ok(service.update(id, controlador));
    }

    /**
     * Remove um controlador com base no seu identificador.
     *
     * <p>
     * Requisição: {@code DELETE /controladores/{id}}
     * </p>
     *
     * @param id identificador do controlador a ser removido
     * @return {@link ResponseEntity} sem conteúdo (HTTP 204) em caso de sucesso
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um controlador por ID")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
