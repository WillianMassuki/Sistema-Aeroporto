package br.com.projeto.aeroporto.embarque.model;

import jakarta.persistence.*;

/**
 * Entidade que representa uma bagagem no sistema.
 *
 * <p>
 * Esta classe é mapeada para uma tabela no banco de dados por meio da JPA, onde cada
 * instância corresponde a um registro de bagagem, contendo um código identificador,
 * um nome e o peso da bagagem.
 * </p>
 */
@Entity
public class Bagagem {

    /**
     * Identificador único da bagagem.
     *
     * <p>
     * Gerado automaticamente pelo banco de dados utilizando a estratégia
     * {@link GenerationType#IDENTITY}.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoBagagem;

    /**
     * Nome ou descrição da bagagem.
     */
    @Column
    private String nome;

    /**
     * Peso da bagagem, em unidades definidas pela regra de negócio
     * (geralmente em quilogramas).
     */
    @Column
    private Double peso;

    /**
     * Construtor padrão sem argumentos.
     *
     * <p>
     * Necessário para o funcionamento da JPA.
     * </p>
     */
    public Bagagem() {
    }

    /**
     * Construtor completo da classe {@code Bagagem}.
     *
     * @param codigoBagagem identificador único da bagagem
     * @param nome          nome ou descrição da bagagem
     * @param peso          peso da bagagem
     */
    public Bagagem(Long codigoBagagem, String nome, Double peso) {
        this.codigoBagagem = codigoBagagem;
        this.nome = nome;
        this.peso = peso;
    }

    /**
     * Obtém o código (ID) da bagagem.
     *
     * @return identificador único da bagagem
     */
    public Long getCodigoBagagem() {
        return codigoBagagem;
    }

    /**
     * Define o código (ID) da bagagem.
     *
     * @param codigoBagagem identificador único da bagagem
     */
    public void setCodigoBagagem(Long codigoBagagem) {
        this.codigoBagagem = codigoBagagem;
    }

    /**
     * Obtém o nome ou descrição da bagagem.
     *
     * @return nome da bagagem
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome ou descrição da bagagem.
     *
     * @param nome nome da bagagem
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o peso da bagagem.
     *
     * @return peso da bagagem
     */
    public Double getPeso() {
        return peso;
    }

    /**
     * Define o peso da bagagem.
     *
     * @param peso peso da bagagem
     */
    public void setPeso(Double peso) {
        this.peso = peso;
    }
}