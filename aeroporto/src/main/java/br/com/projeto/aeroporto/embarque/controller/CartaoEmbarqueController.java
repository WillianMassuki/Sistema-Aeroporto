package br.com.projeto.aeroporto.embarque.controller;


import br.com.projeto.aeroporto.embarque.in.CartaoEmbarqueUseCase;
import br.com.projeto.aeroporto.embarque.model.CartaoEmbarque;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por expor os endpoints relacionados
 * à entidade {@link CartaoEmbarque}.
 *
 * <p>
 * Esta classe recebe as requisições HTTP, delega a lógica de negócio
 * para o caso de uso {@link CartaoEmbarqueUseCase} e retorna as respostas.
 * </p>
 *
 * <p>
 * Endpoints disponíveis:
 * <ul>
 *   <li><b>POST /cartoes</b> - Cria um novo cartão de embarque</li>
 *   <li><b>GET /cartoes</b> - Lista todos os cartões de embarque</li>
 *   <li><b>GET /cartoes/{id}</b> - Busca um cartão de embarque pelo ID</li>
 *   <li><b>PUT /cartoes/{id}</b> - Atualiza um cartão de embarque existente</li>
 *   <li><b>DELETE /cartoes/{id}</b> - Remove um cartão de embarque pelo ID</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("/cartoes")
public class CartaoEmbarqueController {

    private final CartaoEmbarqueUseCase service;

    /**
     * Construtor da classe {@code CartaoEmbarqueController}.
     *
     * @param service caso de uso responsável pelas operações de negócio
     *                envolvendo {@link CartaoEmbarque}
     */
    public CartaoEmbarqueController(CartaoEmbarqueUseCase service) {
        this.service = service;
    }

    /**
     * Cria ou salva um novo cartão de embarque.
     *
     * <p>
     * Requisição: {@code POST /cartoes}
     * </p>
     *
     * @param c objeto {@link CartaoEmbarque} enviado no corpo da requisição
     * @return o {@link CartaoEmbarque} salvo, incluindo o ID gerado (se for novo)
     */
    @PostMapping
    public CartaoEmbarque salvar(@RequestBody CartaoEmbarque c) {
        return service.salvar(c);
    }

    /**
     * Lista todos os cartões de embarque cadastrados.
     *
     * <p>
     * Requisição: {@code GET /cartoes}
     * </p>
     *
     * @return lista de {@link CartaoEmbarque}
     */
    @GetMapping
    public List<CartaoEmbarque> listar() {
        return service.listar();
    }

    /**
     * Busca um cartão de embarque específico pelo seu identificador.
     *
     * <p>
     * Requisição: {@code GET /cartoes/{id}}
     * </p>
     *
     * @param id identificador único do cartão de embarque
     * @return o {@link CartaoEmbarque} correspondente ao ID informado
     *         (ou lança exceção, conforme implementação de {@link CartaoEmbarqueUseCase})
     */
    @GetMapping("/{id}")
    public CartaoEmbarque buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Atualiza os dados de um cartão de embarque existente.
     *
     * <p>
     * Requisição: {@code PUT /cartoes/{id}}
     * </p>
     *
     * @param id identificador do cartão de embarque a ser atualizado
     * @param c  objeto {@link CartaoEmbarque} com os novos dados
     * @return o {@link CartaoEmbarque} atualizado
     */
    @PutMapping("/{id}")
    public CartaoEmbarque atualizar(@PathVariable Long id, @RequestBody CartaoEmbarque c) {
        return service.atualizar(id, c);
    }

    /**
     * Remove um cartão de embarque com base no seu identificador.
     *
     * <p>
     * Requisição: {@code DELETE /cartoes/{id}}
     * </p>
     *
     * @param id identificador do cartão de embarque a ser removido
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}