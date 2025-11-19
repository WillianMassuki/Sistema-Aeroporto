package br.com.projeto.aeroporto.gestaofinanceira.controller;


import br.com.projeto.aeroporto.gestaofinanceira.model.Despesa;
import br.com.projeto.aeroporto.gestaofinanceira.service.DespesaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST responsável por expor os endpoints relacionados à entidade {@link Despesa}.
 *
 * <p>
 * Esta classe recebe as requisições HTTP, delega a lógica de negócio para o serviço
 * {@link DespesaService} e retorna as respostas diretamente como entidades.
 * </p>
 *
 * <p>
 * Endpoints baseados no path: <b>/despesas</b>
 * </p>
 */
@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private final DespesaService despesaUseCase;

    /**
     * Construtor da classe {@code DespesaController}.
     *
     * @param despesaUseCase serviço responsável pelas operações de negócio envolvendo {@link Despesa}
     */
    public DespesaController(DespesaService despesaUseCase) {
        this.despesaUseCase = despesaUseCase;
    }

    /**
     * Cria ou salva uma nova despesa.
     *
     * <p>
     * Requisição: {@code POST /despesas}
     * </p>
     *
     * @param despesa objeto {@link Despesa} enviado no corpo da requisição
     * @return a {@link Despesa} salva, possivelmente com ID gerado
     */
    @PostMapping
    public Despesa salvar(@RequestBody Despesa despesa) {
        return despesaUseCase.salvar(despesa);
    }

    /**
     * Lista todas as despesas cadastradas.
     *
     * <p>
     * Requisição: {@code GET /despesas}
     * </p>
     *
     * @return lista de {@link Despesa}
     */
    @GetMapping
    public List<Despesa> listar() {
        return despesaUseCase.listar();
    }

    /**
     * Busca uma despesa específica pelo seu identificador.
     *
     * <p>
     * Requisição: {@code GET /despesas/{id}}
     * </p>
     *
     * @param id identificador único da despesa
     * @return a {@link Despesa} correspondente ao ID informado
     * @throws RuntimeException (ou exceção específica) caso a despesa não seja encontrada,
     *                          a depender da implementação de {@link DespesaService}
     */
    @GetMapping("/{id}")
    public Despesa buscar(@PathVariable Long id) {
        return despesaUseCase.buscarPorId(id);
    }

    /**
     * Remove uma despesa com base no seu identificador.
     *
     * <p>
     * Requisição: {@code DELETE /despesas/{id}}
     * </p>
     *
     * @param id identificador da despesa a ser removida
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        despesaUseCase.deletar(id);
    }
}