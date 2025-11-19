package br.com.projeto.aeroporto.gestaofinanceira.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;


/**
 * Entidade que representa uma despesa no sistema financeiro.
 *
 * <p>
 * Cada {@code Despesa} possui informações como categoria, valor, data,
 * descrição e está associada a um {@link Fornecedor} e a um {@link Relatorio}.
 * </p>
 */
@Entity
public class Despesa {

    /**
     * Identificador único da despesa.
     *
     * <p>
     * Gerado automaticamente pelo banco de dados utilizando a estratégia
     * {@link GenerationType#AUTO}.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDespesa;

    /**
     * Categoria da despesa.
     *
     * <p>
     * Exemplos: "ALIMENTAÇÃO", "TRANSPORTE", "SERVIÇOS", etc.,
     * conforme a regra de negócio adotada.
     * </p>
     */
    private String categoria;

    /**
     * Valor monetário da despesa.
     */
    private Double valor;

    /**
     * Data e hora em que a despesa foi registrada ou ocorreu.
     */
    private LocalDateTime data;

    /**
     * Descrição detalhada da despesa.
     *
     * <p>
     * Pode conter informações adicionais como motivo, observações,
     * número de documento, etc.
     * </p>
     */
    private String descricao;

    /**
     * Fornecedor associado a esta despesa.
     *
     * <p>
     * Relacionamento muitos-para-um com {@link Fornecedor}, indicando
     * que um fornecedor pode estar vinculado a várias despesas.
     * A chave estrangeira é armazenada na coluna {@code id_fornecedor}.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "id_fornecedor")
    private Fornecedor fornecedor;

    /**
     * Relatório financeiro ao qual esta despesa está vinculada.
     *
     * <p>
     * Relacionamento muitos-para-um com {@link Relatorio}.
     * A chave estrangeira é armazenada na coluna {@code id_relatorio}.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "id_relatorio")
    private Relatorio relatorio;

    /**
     * Construtor padrão sem argumentos.
     *
     * <p>
     * Necessário para o funcionamento da JPA.
     * </p>
     */
    public Despesa() {
    }

    /**
     * Construtor completo da classe {@code Despesa} (sem associações).
     *
     * @param idDespesa identificador único da despesa
     * @param categoria categoria da despesa
     * @param valor     valor da despesa
     * @param data      data e hora da despesa
     * @param descricao descrição detalhada da despesa
     */
    public Despesa(Long idDespesa, String categoria, Double valor, LocalDateTime data, String descricao) {
        this.idDespesa = idDespesa;
        this.categoria = categoria;
        this.valor = valor;
        this.data = data;
        this.descricao = descricao;
    }

    /**
     * Obtém o identificador da despesa.
     *
     * @return ID da despesa
     */
    public Long getIdDespesa() {
        return idDespesa;
    }

    /**
     * Define o identificador da despesa.
     *
     * @param idDespesa identificador único da despesa
     */
    public void setIdDespesa(Long idDespesa) {
        this.idDespesa = idDespesa;
    }

    /**
     * Obtém a categoria da despesa.
     *
     * @return categoria da despesa
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define a categoria da despesa.
     *
     * @param categoria categoria da despesa
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Obtém o valor da despesa.
     *
     * @return valor da despesa
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Define o valor da despesa.
     *
     * @param valor valor da despesa
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * Obtém a data da despesa.
     *
     * @return data e hora da despesa
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * Define a data da despesa.
     *
     * @param data data e hora da despesa
     */
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    /**
     * Obtém a descrição da despesa.
     *
     * @return descrição da despesa
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição da despesa.
     *
     * @param descricao descrição detalhada da despesa
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

