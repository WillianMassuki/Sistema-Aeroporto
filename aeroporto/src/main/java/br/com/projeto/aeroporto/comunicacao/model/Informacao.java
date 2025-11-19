package br.com.projeto.aeroporto.comunicacao.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Representa uma informação operacional ou de comunicação no sistema.
 *
 * <p>
 * A entidade {@code Informacao} pode ser usada, por exemplo, para registrar
 * avisos de embarque, atrasos, alterações de portão, entre outros tipos de
 * mensagens relevantes para passageiros e funcionários.
 * </p>
 */
@Entity
public class Informacao {

    /**
     * Identificador único da informação.
     *
     * <p>
     * Pode ser um identificador gerado pela aplicação (UUID, por exemplo).
     * </p>
     */
    @Id
    private String idInformacao;

    /**
     * Tipo da informação.
     *
     * <p>
     * Exemplos: {@code "embarque"}, {@code "atraso"}, {@code "cancelamento"}.
     * Campo obrigatório.
     * </p>
     */
    @Column(nullable = false)
    private String tipo; // exemplo: "embarque", "atraso"

    /**
     * Conteúdo da informação, representado por uma entidade {@link Mensagem}.
     *
     * <p>
     * Relacionamento um-para-um obrigatório ({@code optional = false}).
     * A coluna de junção no banco é {@code id_mensagem}.
     * </p>
     */
    @OneToOne(optional = false)
    @JoinColumn(name = "id_mensagem", nullable = false)
    private Mensagem conteudo;

    /**
     * Data e hora de validade da informação.
     *
     * <p>
     * Indica até quando essa informação deve ser considerada válida
     * (por exemplo, fim do embarque ou horário após o qual o aviso
     * não faz mais sentido).
     * Campo obrigatório.
     * </p>
     */
    @Column(nullable = false)
    private LocalDateTime validade;

    /**
     * Funcionário associado à informação, quando aplicável.
     *
     * <p>
     * Pode ser o funcionário responsável por emitir, aprovar ou
     * ser notificado sobre essa informação.
     * </p>
     */
    @OneToOne
    @JoinColumn(name = "id_funcionario")
    private Funcionario funcionario;

    /**
     * Retorna o identificador da informação.
     *
     * @return id da informação
     */
    public String getIdInformacao() {
        return idInformacao;
    }

    /**
     * Define o identificador da informação.
     *
     * @param idInformacao novo identificador da informação
     */
    public void setIdInformacao(String idInformacao) {
        this.idInformacao = idInformacao;
    }

    /**
     * Retorna o tipo da informação.
     *
     * @return tipo da informação (ex.: "embarque", "atraso")
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da informação.
     *
     * @param tipo novo tipo da informação
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a data e hora de validade da informação.
     *
     * @return validade da informação
     */
    public LocalDateTime getValidade() {
        return validade;
    }

    /**
     * Define a data e hora de validade da informação.
     *
     * @param validade nova data/hora de validade
     */
    public void setValidade(LocalDateTime validade) {
        this.validade = validade;
    }

    /**
     * Construtor completo para criação de instâncias de {@code Informacao}
     * sem associar entidades externas diretamente.
     *
     * @param idInformacao identificador da informação
     * @param tipo         tipo da informação (ex.: "embarque", "atraso")
     * @param validade     data e hora de validade da informação
     */
    public Informacao(String idInformacao, String tipo, LocalDateTime validade) {
        this.idInformacao = idInformacao;
        this.tipo = tipo;
        this.validade = validade;
    }

    /**
     * Construtor padrão exigido pelo JPA.
     *
     * <p>
     * Não deve conter lógica de negócio.
     * </p>
     */
    public Informacao() {
    }
}



