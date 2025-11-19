package br.com.projeto.aeroporto.gestaofinanceira.controller;



import br.com.projeto.aeroporto.gestaofinanceira.model.Despesa;
import br.com.projeto.aeroporto.gestaofinanceira.model.Receita;
import br.com.projeto.aeroporto.gestaofinanceira.model.Relatorio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador REST responsável por operações do Sistema de Gestão Financeira.
 *
 * <p>
 * Esta classe representa a camada de apresentação de um sistema financeiro,
 * sendo o ponto de entrada para funcionalidades como:
 * </p>
 * <ul>
 *     <li>Registro de receitas</li>
 *     <li>Registro de despesas</li>
 *     <li>Geração de relatórios financeiros</li>
 * </ul>
 *
 * <p>
 * Atualmente, os métodos ainda não possuem implementação nem mapeamentos HTTP
 * específicos ({@code @PostMapping}, {@code @GetMapping}, etc.), funcionando como
 * placeholders para futuras funcionalidades.
 * </p>
 */
@RestController
@RequestMapping("/SistemaFinanceiro")
public class SistemaGestaoFinanceiraController {

    /**
     * Registra uma nova receita no sistema financeiro.
     *
     * <p>
     * Método ainda sem implementação. Deve futuramente receber uma requisição contendo
     * os dados de {@link Receita} e delegar o processamento para a camada de serviço.
     * </p>
     *
     * @param receita objeto {@link Receita} que representa a receita a ser registrada
     */
    public void registrarReceita(Receita receita) {

    }

    /**
     * Registra uma nova despesa no sistema financeiro.
     *
     * <p>
     * Método ainda sem implementação. Deve futuramente receber uma requisição contendo
     * os dados de {@link Despesa} e delegar o processamento para a camada de serviço.
     * </p>
     *
     * @param despesa objeto {@link Despesa} que representa a despesa a ser registrada
     */
    public void registrarDespesa(Despesa despesa) {

    }

    /**
     * Gera um relatório financeiro consolidado.
     *
     * <p>
     * Método ainda sem implementação. A expectativa é que, no futuro, ele consolide
     * as informações de receitas e despesas e retorne um {@link Relatorio} com os dados
     * financeiros do período desejado.
     * </p>
     *
     * @return um objeto {@link Relatorio} contendo o resumo financeiro,
     *         atualmente retornando {@code null} como placeholder
     */
    public Relatorio gerarRelatorioFinanceiro() {
        return null;
    }

}