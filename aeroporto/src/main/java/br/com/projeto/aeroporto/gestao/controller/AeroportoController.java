package br.com.projeto.aeroporto.gestao.controller;


import br.com.projeto.aeroporto.gestao.in.AeroportoUseCase;
import br.com.projeto.aeroporto.gestao.model.Aeroporto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações sobre {@link Aeroporto}.
 *
 * <p>
 * Expõe endpoints HTTP para criação, listagem, consulta, atualização
 * e exclusão de aeroportos. Toda a lógica de negócio é delegada ao
 * {@link AeroportoUseCase}.
 * </p>
 *
 * <p>
 * Endpoints principais:
 * <ul>
 *   <li>POST {@code /aeroportos} – cria um novo aeroporto</li>
 *   <li>GET {@code /aeroportos} – lista todos os aeroportos</li>
 *   <li>GET {@code /aeroportos/{id}} – busca aeroporto por ID</li>
 *   <li>PUT {@code /aeroportos/{id}} – atualiza aeroporto existente</li>
 *   <li>DELETE {@code /aeroportos/{id}} – remove aeroporto</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {

    /**
     * Caso de uso responsável pelas operações de negócio de {@link Aeroporto}.
     */
    private final AeroportoUseCase service;

    /**
     * Construtor com injeção de dependência do caso de uso.
     *
     * @param service implementação de {@link AeroportoUseCase}
     */
    public AeroportoController(AeroportoUseCase service) {
        this.service = service;
    }

    /**
     * Cria um novo aeroporto.
     *
     * <p>
     * Espera um JSON representando o {@link Aeroporto} no corpo da requisição.
     * </p>
     *
     * @param a aeroporto a ser salvo
     * @return aeroporto recém-criado (com ID preenchido)
     */
    @PostMapping
    public Aeroporto salvar(@RequestBody Aeroporto a) {
        return service.salvar(a);
    }

    /**
     * Lista todos os aeroportos cadastrados.
     *
     * @return lista de aeroportos
     */
    @GetMapping
    public List<Aeroporto> listar() {
        return service.listar();
    }

    /**
     * Busca um aeroporto pelo seu identificador.
     *
     * @param id identificador do aeroporto (extraído do caminho da URL)
     * @return aeroporto correspondente ao ID informado
     */
    @GetMapping("/{id}")
    public Aeroporto buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Atualiza os dados de um aeroporto existente.
     *
     * <p>
     * O ID é passado na URL e os novos dados no corpo da requisição.
     * </p>
     *
     * @param id identificador do aeroporto a ser atualizado
     * @param a  objeto contendo os novos dados do aeroporto
     * @return aeroporto atualizado
     */
    @PutMapping("/{id}")
    public Aeroporto atualizar(@PathVariable Long id, @RequestBody Aeroporto a) {
        return service.atualizar(id, a);
    }

    /**
     * Remove um aeroporto com base em seu identificador.
     *
     * @param id identificador do aeroporto a ser removido
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}