package br.com.projeto.aeroporto.embarque.controller;


import br.com.projeto.aeroporto.embarque.in.BagagemUseCase;
import br.com.projeto.aeroporto.embarque.model.Bagagem;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por expor os endpoints relacionados à entidade {@link Bagagem}.
 *
 * <p>
 * Esta classe recebe as requisições HTTP, delega a lógica de negócio para o caso de uso
 * {@link BagagemUseCase} e retorna as respostas apropriadas.
 * </p>
 *
 * <p>
 * Endpoints disponíveis:
 * <ul>
 *   <li><b>POST /bagagens</b> - Cria uma nova bagagem</li>
 *   <li><b>GET /bagagens</b> - Lista todas as bagagens</li>
 *   <li><b>GET /bagagens/{id}</b> - Busca uma bagagem pelo ID</li>
 *   <li><b>PUT /bagagens/{id}</b> - Atualiza uma bagagem existente</li>
 *   <li><b>DELETE /bagagens/{id}</b> - Remove uma bagagem pelo ID</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("/bagagens")
public class BagagemController {

    private final BagagemUseCase service;

    /**
     * Construtor da classe {@code BagagemController}.
     *
     * @param service caso de uso responsável pelas operações de negócio envolvendo {@link Bagagem}
     */
    public BagagemController(BagagemUseCase service) {
        this.service = service;
    }

    /**
     * Cria ou salva uma nova bagagem.
     *
     * <p>
     * Requisição: {@code POST /bagagens}
     * </p>
     *
     * @param bagagem objeto {@link Bagagem} enviado no corpo da requisição
     * @return a {@link Bagagem} salva, incluindo o ID gerado (se for nova)
     */
    @PostMapping
    public Bagagem salvar(@RequestBody Bagagem bagagem) {
        return service.salvar(bagagem);
    }

    /**
     * Lista todas as bagagens cadastradas.
     *
     * <p>
     * Requisição: {@code GET /bagagens}
     * </p>
     *
     * @return lista de {@link Bagagem}
     */
    @GetMapping
    public List<Bagagem> listar() {
        return service.listar();
    }

    /**
     * Busca uma bagagem específica pelo seu identificador.
     *
     * <p>
     * Requisição: {@code GET /bagagens/{id}}
     * </p>
     *
     * @param id identificador único da bagagem
     * @return a {@link Bagagem} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso a bagagem não seja encontrada,
     *                          a depender da implementação de {@link BagagemUseCase}
     */
    @GetMapping("/{id}")
    public Bagagem buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Atualiza os dados de uma bagagem existente.
     *
     * <p>
     * Requisição: {@code PUT /bagagens/{id}}
     * </p>
     *
     * @param id       identificador da bagagem a ser atualizada
     * @param bagagem  objeto {@link Bagagem} com os novos dados
     * @return a {@link Bagagem} atualizada
     */
    @PutMapping("/{id}")
    public Bagagem atualizar(@PathVariable Long id, @RequestBody Bagagem bagagem) {
        return service.atualizar(id, bagagem);
    }

    /**
     * Remove uma bagagem com base no seu identificador.
     *
     * <p>
     * Requisição: {@code DELETE /bagagens/{id}}
     * </p>
     *
     * @param id identificador da bagagem a ser removida
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}