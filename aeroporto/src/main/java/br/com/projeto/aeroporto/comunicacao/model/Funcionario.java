package br.com.projeto.aeroporto.comunicacao.model;

import jakarta.persistence.*;

/**
 * Representa um funcionário no sistema.
 *
 * <p>
 * Esta entidade contém informações básicas de cadastro de um funcionário,
 * como nome, cargo e matrícula. Pode, opcionalmente, estar associada a uma
 * entidade {@link Informacao} em um relacionamento um-para-um.
 * </p>
 */
@Entity
public class Funcionario {

    /**
     * Identificador único do funcionário.
     *
     * <p>
     * Valor gerado automaticamente pelo provedor JPA.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idFuncionario;

    /**
     * Nome completo do funcionário.
     *
     * <p>
     * Campo obrigatório.
     * </p>
     */
    @Column(nullable = false)
    private String nome;

    /**
     * Cargo ou função exercida pelo funcionário.
     *
     * <p>
     * Exemplo: "Atendente", "Supervisor de Pista", "Gerente".
     * Campo obrigatório.
     * </p>
     */
    @Column(nullable = false)
    private String cargo;

    /**
     * Matrícula única do funcionário no sistema.
     *
     * <p>
     * Campo obrigatório e único, utilizado para identificação interna.
     * </p>
     */
    @Column(nullable = false, unique = true)
    private String matricula;

    /**
     * Informação associada a este funcionário.
     *
     * <p>
     * Relacionamento opcional um-para-um com {@link Informacao},
     * mapeado pelo atributo {@code funcionario} na entidade {@code Informacao}.
     * Este campo só é utilizado se for desejado um relacionamento bidirecional.
     * </p>
     */
    @OneToOne(mappedBy = "funcionario")
    private Informacao informacao;

    /**
     * Construtor padrão exigido pelo JPA.
     *
     * <p>
     * Não deve conter lógica de negócio.
     * </p>
     */
    public Funcionario() {
    }

    /**
     * Construtor completo para criação de instâncias de {@code Funcionario}.
     *
     * @param id        identificador do funcionário
     * @param nome      nome do funcionário
     * @param cargo     cargo exercido pelo funcionário
     * @param matricula matrícula única do funcionário
     */
    public Funcionario(Long id, String nome, String cargo, String matricula) {
        this.idFuncionario = id;
        this.nome = nome;
        this.cargo = cargo;
        this.matricula = matricula;
    }

    /**
     * Retorna o identificador do funcionário.
     *
     * @return id do funcionário
     */
    public Long getId() {
        return idFuncionario;
    }

    /**
     * Define o identificador do funcionário.
     *
     * @param id novo id do funcionário
     */
    public void setId(Long id) {
        this.idFuncionario = id;
    }

    /**
     * Retorna o nome do funcionário.
     *
     * @return nome do funcionário
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do funcionário.
     *
     * @param nome novo nome do funcionário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o cargo do funcionário.
     *
     * @return cargo do funcionário
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * Define o cargo do funcionário.
     *
     * @param cargo novo cargo do funcionário
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * Retorna a matrícula do funcionário.
     *
     * @return matrícula do funcionário
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * Define a matrícula do funcionário.
     *
     * @param matricula nova matrícula do funcionário
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}