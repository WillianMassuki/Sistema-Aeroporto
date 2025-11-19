package br.com.projeto.aeroporto.gestao.controller;


import br.com.projeto.aeroporto.gestao.in.PassageiroUseCase;
import br.com.projeto.aeroporto.gestao.model.Passageiro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para operações sobre {@link Passageiro}.
 *
 * <p>
 * Expõe endpoints HTTP para criação, listagem, consulta, atualização
 * e exclusão de passageiros. Toda a lógica de negócio é delegada ao
 * {@link PassageiroUseCase}.
 * </p>
 *
 * <p>
 * Endpoints principais:
 * <ul>
 *   <li>POST {@code /passageiros} – cria um novo passageiro</li>
 *   <li>GET {@code /passageiros} – lista todos os passageiros</li>
 *   <li>GET {@code /passageiros/{id}} – busca passageiro por ID</li>
 *   <li>PUT {@code /passageiros/{id}} – atualiza passageiro existente</li>
 *   <li>DELETE {@code /passageiros/{id}} – remove passageiro</li>
 * </ul>
 * </p>
 */
@RestController
@RequestMapping("/passageiros")
public class PassageiroController {

    /**
     * Caso de uso responsável pelas operações de negócio de {@link Passageiro}.
     */
    private final PassageiroUseCase service;

    /**
     * Construtor com injeção de dependência do caso de uso.
     *
     * @param service implementação de {@link PassageiroUseCase}
     */
    public PassageiroController(PassageiroUseCase service) {
        this.service = service;
    }

    /**
     * Cria um novo passageiro.
     *
     * <p>
     * Espera um JSON representando o {@link Passageiro} no corpo da requisição.
     * </p>
     *
     * @param p passageiro a ser salvo
     * @return passageiro recém-criado (normalmente com ID preenchido)
     */
    @PostMapping
    public Passageiro salvar(@RequestBody Passageiro p) {
        return service.salvar(p);
    }

    /**
     * Lista todos os passageiros cadastrados.
     *
     * @return lista de passageiros
     */
    @GetMapping
    public List<Passageiro> listar() {
        return service.listar();
    }

    /**
     * Busca um passageiro pelo seu identificador.
     *
     * @param id identificador do passageiro (extraído do caminho da URL)
     * @return passageiro correspondente ao ID informado
     */
    @GetMapping("/{id}")
    public Passageiro buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    /**
     * Atualiza os dados de um passageiro existente.
     *
     * <p>
     * O ID é passado na URL e os novos dados no corpo da requisição.
     * </p>
     *
     * @param id identificador do passageiro a ser atualizado
     * @param p  objeto contendo os novos dados do passageiro
     * @return passageiro atualizado
     */
    @PutMapping("/{id}")
    public Passageiro atualizar(@PathVariable Long id, @RequestBody Passageiro p) {
        return service.atualizar(id, p);
    }

    /**
     * Remove um passageiro com base em seu identificador.
     *
     * @param id identificador do passageiro a ser removido
     */
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
