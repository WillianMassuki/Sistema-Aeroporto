package br.com.projeto.aeroporto.gestao.controller;


import br.com.projeto.aeroporto.gestao.in.BilheteUseCase;
import br.com.projeto.aeroporto.gestao.model.Bilhete;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações sobre {@link Bilhete}.
 *
 * <p>
 * Expõe endpoints HTTP para criação, listagem, consulta, atualização
 * e exclusão de bilhetes. Toda a lógica de negócio é delegada ao
 * {@link BilheteUseCase}.
 * </p>
 *
 * <p>
 * Endpoints principais:
 * <ul>
 *   <li>POST {@code /bilhetes} – cria um novo bilhete</li>
 *   <li>GET {@code /bilhetes} – lista todos os bilhetes</li>
 *   <li>GET {@code /bilhetes/{id}} – busca bilhete por ID</li>
 *   <li>PUT {@code /bilhetes/{id}} – atualiza bilhete existente</li>
 *   <li>DELETE {@code /bilhetes/{id}} – remove bilhete</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("/bilhetes")
public class BilheteController {

    /**
     * Caso de uso responsável pelas operações de negócio de {@link Bilhete}.
     */
    private final BilheteUseCase service;

    /**
     * Construtor com injeção de dependência do caso de uso.
     *
     * @param service implementação de {@link BilheteUseCase}
     */
    public BilheteController(BilheteUseCase service) {
        this.service = service;
    }

    /**
     * Cria um novo bilhete.
     *
     * <p>
     * Espera um JSON representando o {@link Bilhete} no corpo da requisição.
     * </p>
     *
     * @param b bilhete a ser salvo
     * @return bilhete recém-criado (normalmente com ID preenchido)
     */
    @PostMapping
    public Bilhete salvar(@RequestBody Bilhete b) {
        return service.salvar(b);
    }

    /**
     * Lista todos os bilhetes cadastrados.
     *
     * @return lista de bilhetes
     */
    @GetMapping
    public List<Bilhete> listar() {
        return service.listar();
    }

    /**
     * Busca um bilhete pelo seu identificador.
     *
     * @param id identificador do bilhete (extraído do caminho da URL)
     * @return bilhete correspondente ao ID informado
     */
    @GetMapping("/{id}")
    public Bilhete buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Atualiza os dados de um bilhete existente.
     *
     * <p>
     * O ID é passado na URL e os novos dados no corpo da requisição.
     * </p>
     *
     * @param id identificador do bilhete a ser atualizado
     * @param b  objeto contendo os novos dados do bilhete
     * @return bilhete atualizado
     */
    @PutMapping("/{id}")
    public Bilhete atualizar(@PathVariable Long id, @RequestBody Bilhete b) {
        return service.atualizar(id, b);
    }

    /**
     * Remove um bilhete com base em seu identificador.
     *
     * @param id identificador do bilhete a ser removido
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
