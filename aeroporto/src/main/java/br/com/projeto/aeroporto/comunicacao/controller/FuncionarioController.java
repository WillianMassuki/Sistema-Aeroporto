package br.com.projeto.aeroporto.comunicacao.controller;


import br.com.projeto.aeroporto.comunicacao.in.FuncionarioUseCase;
import br.com.projeto.aeroporto.comunicacao.model.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações sobre {@link Funcionario}.
 *
 * <p>
 * Expõe endpoints HTTP para criação, consulta, listagem, atualização
 * e exclusão de funcionários. Toda a lógica de negócio é delegada ao
 * caso de uso {@link FuncionarioUseCase}.
 * </p>
 *
 * <p>
 * Base path dos endpoints: {@code /api/funcionarios}.
 * </p>
 */
@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    /**
     * Caso de uso responsável pelas operações de negócio relacionadas a {@link Funcionario}.
     */
    private final FuncionarioUseCase funcionarioUseCase;

    /**
     * Construtor com injeção de dependência do caso de uso.
     *
     * @param funcionarioUseCase implementação de {@link FuncionarioUseCase}
     */
    public FuncionarioController(FuncionarioUseCase funcionarioUseCase) {
        this.funcionarioUseCase = funcionarioUseCase;
    }

    /**
     * Cria um novo funcionário.
     *
     * <p>
     * Endpoint: {@code POST /api/funcionarios}
     * </p>
     *
     * @param funcionario dados do funcionário a ser criado (JSON no corpo da requisição)
     * @return {@link ResponseEntity} contendo o funcionário criado e status HTTP 200 (OK)
     */
    @PostMapping
    @Operation(summary = "Criação do cadastro do Funcionario")
    public ResponseEntity<Funcionario> criar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(funcionarioUseCase.criar(funcionario));
    }

    /**
     * Busca um funcionário pelo seu identificador.
     *
     * <p>
     * Endpoint: {@code GET /api/funcionarios/{id}}
     * </p>
     *
     * @param id identificador do funcionário
     * @return {@link ResponseEntity} contendo o funcionário (status 200) se encontrado,
     *         ou status 404 (Not Found) caso contrário
     */
    @GetMapping("/{id}")
    @Operation(summary = "Buscar funcionario pelo codigo")
    public ResponseEntity<Funcionario> buscarPorId(@PathVariable Long id) {
        return funcionarioUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Lista todos os funcionários cadastrados.
     *
     * <p>
     * Endpoint: {@code GET /api/funcionarios}
     * </p>
     *
     * @return {@link ResponseEntity} contendo a lista de funcionários e status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Funcionario>> listar() {
        return ResponseEntity.ok(funcionarioUseCase.listar());
    }

    /**
     * Atualiza os dados de um funcionário existente.
     *
     * <p>
     * Endpoint: {@code PUT /api/funcionarios/{id}}
     * </p>
     *
     * @param id          identificador do funcionário a ser atualizado
     * @param funcionario objeto com os novos dados do funcionário
     * @return {@link ResponseEntity} contendo o funcionário atualizado (status 200)
     *         ou status 404 (Not Found) se o funcionário não existir
     */
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizar(@PathVariable Long id, @RequestBody Funcionario funcionario) {
        try {
            Funcionario atualizado = funcionarioUseCase.atualizar(id, funcionario);
            return ResponseEntity.ok(atualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Remove um funcionário com base em seu identificador.
     *
     * <p>
     * Endpoint: {@code DELETE /api/funcionarios/{id}}
     * </p>
     *
     * @param id identificador do funcionário a ser removido
     * @return {@link ResponseEntity} com status 204 (No Content) após a exclusão
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        funcionarioUseCase.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
