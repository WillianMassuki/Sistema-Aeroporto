package br.com.projeto.aeroporto.controlevoo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

/**
 * Entidade que representa um controlador de voo no sistema.
 *
 * <p>
 * Cada {@code Controlador} possui um identificador, nome, matrícula e
 * está associado a um registro de {@link ControleDeVoo} por meio de um
 * relacionamento um-para-um.
 * </p>
 */
@Entity
public class Controlador {

    /**
     * Identificador único do controlador.
     *
     * <p>
     * Utilizado como chave primária da entidade.
     * </p>
     */
    @Id
    private Long idControlador;

    /**
     * Nome do controlador de voo.
     */
    private String nome;

    /**
     * Matrícula (identificação funcional) do controlador.
     */
    private String matricula;

    /**
     * Registro de controle de voo associado a este controlador.
     *
     * <p>
     * Relacionamento um-para-um mapeado pelo atributo {@code controlador}
     * na entidade {@link ControleDeVoo}.
     * </p>
     */
    @OneToOne(mappedBy = "controlador")
    private ControleDeVoo controle;

    /**
     * Construtor padrão sem argumentos.
     *
     * <p>
     * Necessário para o funcionamento da JPA.
     * </p>
     */
    public Controlador() {
    }

    /**
     * Construtor completo da classe {@code Controlador}.
     *
     * @param id        identificador único do controlador
     * @param nome      nome do controlador
     * @param matricula matrícula (identificação funcional) do controlador
     */
    public Controlador(Long id, String nome, String matricula) {
        this.idControlador = id;
        this.nome = nome;
        this.matricula = matricula;
    }

    /**
     * Obtém o identificador do controlador.
     *
     * @return ID do controlador
     */
    public Long getIdControlador() {
        return idControlador;
    }

    /**
     * Define o identificador do controlador.
     *
     * @param id identificador único do controlador
     */
    public void setIdControlador(Long id) {
        this.idControlador = id;
    }

    /**
     * Obtém o nome do controlador.
     *
     * @return nome do controlador
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do controlador.
     *
     * @param nome nome do controlador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém a matrícula do controlador.
     *
     * @return matrícula do controlador
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define a matrícula do controlador.
     *
     * @param matricula matrícula do controlador
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Obtém o controle de voo associado a este controlador.
     *
     * @return instância de {@link ControleDeVoo} associada
     */
    public ControleDeVoo getControle() {
        return controle;
    }

    /**
     * Define o controle de voo associado a este controlador.
     *
     * @param controle instância de {@link ControleDeVoo}
     */
    public void setControle(ControleDeVoo controle) {
        this.controle = controle;
    }
}
