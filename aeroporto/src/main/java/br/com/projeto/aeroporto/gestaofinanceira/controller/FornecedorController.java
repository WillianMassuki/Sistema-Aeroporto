package br.com.projeto.aeroporto.gestaofinanceira.controller;


import br.com.projeto.aeroporto.gestaofinanceira.model.Fornecedor;
import br.com.projeto.aeroporto.gestaofinanceira.service.FornecedorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por expor os endpoints relacionados à entidade {@link Fornecedor}.
 *
 * <p>
 * Esta classe recebe as requisições HTTP, delega a lógica de negócio para o serviço
 * {@link FornecedorService} e retorna as respostas diretamente como entidades.
 * </p>
 *
 * <p>
 * Endpoints baseados no path: <b>/fornecedores</b>
 * </p>
 */
@RestController
@RequestMapping("/fornecedores")
public class FornecedorController {

    private final FornecedorService fornecedorService;

    /**
     * Construtor da classe {@code FornecedorController}.
     *
     * @param fornecedorService serviço responsável pelas operações de negócio envolvendo {@link Fornecedor}
     */
    public FornecedorController(FornecedorService fornecedorService) {
        this.fornecedorService = fornecedorService;
    }

    /**
     * Cria ou salva um novo fornecedor.
     *
     * <p>
     * Requisição: {@code POST /fornecedores}
     * </p>
     *
     * @param fornecedor objeto {@link Fornecedor} enviado no corpo da requisição
     * @return o {@link Fornecedor} salvo, possivelmente com ID gerado
     */
    @PostMapping
    public Fornecedor salvar(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.salvar(fornecedor);
    }

    /**
     * Lista todos os fornecedores cadastrados.
     *
     * <p>
     * Requisição: {@code GET /fornecedores}
     * </p>
     *
     * @return lista de {@link Fornecedor}
     */
    @GetMapping
    public List<Fornecedor> listar() {
        return fornecedorService.listar();
    }

    /**
     * Busca um fornecedor específico pelo seu identificador.
     *
     * <p>
     * Requisição: {@code GET /fornecedores/{id}}
     * </p>
     *
     * @param id identificador único do fornecedor
     * @return o {@link Fornecedor} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso o fornecedor não seja encontrado,
     *                          a depender da implementação de {@link FornecedorService}
     */
    @GetMapping("/{id}")
    public Fornecedor buscar(@PathVariable Long id) {
        return fornecedorService.buscarPorId(id);
    }

    /**
     * Atualiza os dados de um fornecedor existente.
     *
     * <p>
     * Requisição: {@code PUT /fornecedores/{id}}
     * </p>
     *
     * @param id identificador do fornecedor a ser atualizado
     * @param b  objeto {@link Fornecedor} contendo os novos dados
     * @return o {@link Fornecedor} atualizado
     */
    @PutMapping("/{id}")
    public Fornecedor atualizar(@PathVariable Long id, @RequestBody Fornecedor b) {
        return fornecedorService.atualizar(id, b);
    }

    /**
     * Remove um fornecedor com base no seu identificador.
     *
     * <p>
     * Requisição: {@code DELETE /fornecedores/{id}}
     * </p>
     *
     * @param id identificador do fornecedor a ser removido
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        fornecedorService.deletar(id);
    }
}