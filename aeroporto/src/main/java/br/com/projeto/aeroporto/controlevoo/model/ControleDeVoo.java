package br.com.projeto.aeroporto.controlevoo.model;

import jakarta.persistence.*;

/**
 * Entidade que representa o controle de voo no sistema.
 *
 * <p>
 * Um {@code ControleDeVoo} registra o status atual de um voo,
 * o {@link Controlador} responsável e a {@link TorreDeControle} à qual está associado.
 * </p>
 */
@Entity
public class ControleDeVoo {

    /**
     * Identificador único do controle de voo.
     *
     * <p>
     * Gerado automaticamente pelo banco de dados utilizando a estratégia
     * {@link GenerationType#AUTO}.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idControle;

    /**
     * Status atual do voo.
     *
     * <p>
     * Exemplos: "EM_ANDAMENTO", "ATERRISSADO", "CANCELADO" etc,
     * conforme a regra de negócio adotada.
     * </p>
     */
    private String status;

    /**
     * Controlador responsável por este controle de voo.
     *
     * <p>
     * Relacionamento um-para-um com {@link Controlador}. A coluna
     * {@code controlador_id} armazena a chave estrangeira para o controlador.
     * </p>
     */
    @OneToOne
    @JoinColumn(name = "controlador_id")
    private Controlador controlador;

    /**
     * Torre de controle à qual este controle de voo está vinculado.
     *
     * <p>
     * Relacionamento muitos-para-um com {@link TorreDeControle}, ou seja,
     * várias instâncias de {@code ControleDeVoo} podem estar associadas
     * à mesma torre.
     * </p>
     */
    @ManyToOne
    @JoinColumn(name = "torre_id")
    private TorreDeControle torreDeControle;

    /**
     * Construtor padrão sem argumentos.
     *
     * <p>
     * Necessário para o funcionamento da JPA.
     * </p>
     */
    public ControleDeVoo() {
    }

    /**
     * Construtor completo da classe {@code ControleDeVoo}.
     *
     * @param idControle      identificador único do controle de voo
     * @param status          status atual do voo
     * @param controlador     controlador responsável
     * @param torreDeControle torre de controle associada
     */
    public ControleDeVoo(Long idControle, String status, Controlador controlador, TorreDeControle torreDeControle) {
        this.idControle = idControle;
        this.status = status;
        this.controlador = controlador;
        this.torreDeControle = torreDeControle;
    }

    /**
     * Obtém o identificador do controle de voo.
     *
     * @return ID do controle de voo
     */
    public Long getIdControle() {
        return idControle;
    }

    /**
     * Define o identificador do controle de voo.
     *
     * @param idControle identificador único do controle de voo
     */
    public void setIdControle(Long idControle) {
        this.idControle = idControle;
    }

    /**
     * Obtém o status atual do controle de voo.
     *
     * @return status do voo
     */
    public String getStatus() {
        return status;
    }

    /**
     * Define o status atual do controle de voo.
     *
     * @param status novo status do voo
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Obtém o controlador responsável por este controle de voo.
     *
     * @return instância de {@link Controlador}
     */
    public Controlador getControlador() {
        return controlador;
    }

    /**
     * Define o controlador responsável por este controle de voo.
     *
     * @param controlador controlador a ser associado
     */
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    /**
     * Obtém a torre de controle associada a este controle de voo.
     *
     * @return instância de {@link TorreDeControle}
     */
    public TorreDeControle getTorreDeControle() {
        return torreDeControle;
    }

    /**
     * Define a torre de controle associada a este controle de voo.
     *
     * @param torreDeControle torre de controle a ser associada
     */
    public void setTorreDeControle(TorreDeControle torreDeControle) {
        this.torreDeControle = torreDeControle;
    }
}