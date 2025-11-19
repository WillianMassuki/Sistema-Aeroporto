package br.com.projeto.aeroporto.gestaofinanceira.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * Entidade que representa um fornecedor no sistema.
 *
 * <p>
 * Um {@code Fornecedor} é responsável por prestar algum tipo de serviço ou fornecer
 * produtos, podendo estar associado a diversas {@link Despesa despesas} registradas.
 * </p>
 */
@Entity
public class Fornecedor {

    /**
     * Identificador único do fornecedor.
     *
     * <p>
     * Gerado automaticamente pelo banco de dados utilizando a estratégia
     * {@link GenerationType#AUTO}.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFornecedor;

    /**
     * Nome do fornecedor.
     */
    private String nome;

    /**
     * Descrição do serviço prestado pelo fornecedor.
     *
     * <p>
     * Exemplos: "Limpeza", "Manutenção", "Consultoria", etc.
     * </p>
     */
    private String servicoPrestado;

    /**
     * Lista de despesas associadas a este fornecedor.
     *
     * <p>
     * Relacionamento um-para-muitos com {@link Despesa}, mapeado pelo atributo
     * {@code fornecedor} na entidade {@link Despesa}.
     * O {@link CascadeType#ALL} indica que operações realizadas sobre o fornecedor
     * (como salvar ou deletar) serão propagadas para suas despesas associadas.
     * </p>
     */
    @OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL)
    private List<Despesa> despesas;

    /**
     * Construtor padrão sem argumentos.
     *
     * <p>
     * Necessário para o funcionamento da JPA.
     * </p>
     */
    public Fornecedor() {
    }

    /**
     * Construtor completo da classe {@code Fornecedor}.
     *
     * @param idFornecedor   identificador único do fornecedor
     * @param nome           nome do fornecedor
     * @param servicoPrestado descrição do serviço prestado
     * @param despesas       lista de despesas associadas
     */
    public Fornecedor(Long idFornecedor, String nome, String servicoPrestado, List<Despesa> despesas) {
        this.idFornecedor = idFornecedor;
        this.nome = nome;
        this.servicoPrestado = servicoPrestado;
        this.despesas = despesas;
    }

    /**
     * Obtém o identificador do fornecedor.
     *
     * @return ID do fornecedor
     */
    public Long getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * Define o identificador do fornecedor.
     *
     * @param idFornecedor identificador único do fornecedor
     */
    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    /**
     * Obtém o nome do fornecedor.
     *
     * @return nome do fornecedor
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do fornecedor.
     *
     * @param nome nome do fornecedor
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a descrição do serviço prestado pelo fornecedor.
     *
     * @return serviço prestado
     */
    public String getServicoPrestado() {
        return servicoPrestado;
    }

    /**
     * Define a descrição do serviço prestado pelo fornecedor.
     *
     * @param servicoPrestado serviço prestado
     */
    public void setServicoPrestado(String servicoPrestado) {
        this.servicoPrestado = servicoPrestado;
    }

    /**
     * Obtém a lista de despesas associadas a este fornecedor.
     *
     * @return lista de {@link Despesa}
     */
    public List<Despesa> getDespesas() {
        return despesas;
    }

    /**
     * Define a lista de despesas associadas a este fornecedor.
     *
     * @param despesas lista de {@link Despesa}
     */
    public void setDespesas(List<Despesa> despesas) {
        this.despesas = despesas;
    }
}
