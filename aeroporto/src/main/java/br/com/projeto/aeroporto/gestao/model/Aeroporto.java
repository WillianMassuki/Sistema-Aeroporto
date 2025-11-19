package br.com.projeto.aeroporto.gestao.model;

import jakarta.persistence.*;

/**
 * Representa um aeroporto no sistema.
 * Esta entidade é mapeada para uma tabela no banco de dados e contém
 * informações básicas como identificador, nome e código do aeroporto.
 */
@Entity
public class Aeroporto {

    /**
     * Identificador único do aeroporto.
     * Gerado automaticamente pelo provedor JPA.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAeroporto;

    /**
     * Nome do aeroporto.
     * Exemplo: "Aeroporto Internacional de Guarulhos".
     */
    @Column
    private String nome;

    /**
     * Código identificador do aeroporto.
     * Pode representar, por exemplo, o código IATA ou outro código definido
     * pelas regras de negócio do sistema.
     * Exemplo: "GRU", "CGH".
     */
    @Column
    private String codigo;

    /**
     * Construtor padrão exigido pelo JPA.
     * Não deve conter lógica, é utilizado internamente pelo framework.
     */
    public Aeroporto() {
    }

    /**
     * Construtor completo da entidade Aeroporto.
     *
     * @param idAeroporto identificador único do aeroporto
     * @param nome        nome do aeroporto
     * @param codigo      código identificador do aeroporto
     */
    public Aeroporto(Long idAeroporto, String nome, String codigo) {
        this.idAeroporto = idAeroporto;
        this.nome = nome;
        this.codigo = codigo;
    }

    /**
     * Retorna o identificador do aeroporto.
     *
     * @return id do aeroporto
     */
    public Long getIdAeroporto() {
        return idAeroporto;
    }

    /**
     * Define o identificador do aeroporto.
     *
     * @param idAeroporto novo id do aeroporto
     */
    public void setIdAeroporto(Long idAeroporto) {
        this.idAeroporto = idAeroporto;
    }

    /**
     * Retorna o nome do aeroporto.
     *
     * @return nome do aeroporto
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do aeroporto.
     *
     * @param nome novo nome do aeroporto
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    /**
     * Retorna o código do aeroporto.
     *
     * @return código do aeroporto
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Define o código do aeroporto.
     *
     * @param codigo novo código do aeroporto
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
