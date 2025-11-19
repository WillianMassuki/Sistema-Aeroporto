package br.com.projeto.aeroporto.gestao.model;


import br.com.projeto.aeroporto.embarque.model.Bagagem;
import jakarta.persistence.*;

/**
 * Representa um bilhete (passagem) de viagem no sistema.
 *
 * A entidade {@code Bilhete} contém informações sobre o número do bilhete,
 * assento, bagagem associada e o passageiro titular.
 */
@Entity
public class Bilhete {

    /**
     * Identificador único do bilhete.
     * Valor gerado automaticamente pelo provedor JPA.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idBilhete;

    /**
     * Número do bilhete.
     * Pode ser o número utilizado pela companhia aérea ou pelo próprio sistema
     * para controle interno.
     */
    private Integer numero;

    /**
     * Assento associado ao bilhete.
     * Exemplo: "12A", "5C".
     */
    private String assento;

    /**
     * Bagagem associada a este bilhete.
     * Relação um-para-um com a entidade {@link Bagagem}. O carregamento é
     * {@code LAZY}, ou seja, a bagagem só é carregada do banco quando acessada.
     * A coluna de junção no banco de dados é {@code codigo}.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigo")
    private Bagagem bagagem;

    /**
     * Passageiro titular deste bilhete.
     * Relação um-para-um com a entidade {@link Passageiro}. Também é carregada
     * de forma preguiçosa ({@code LAZY}).
     * A coluna de junção no banco de dados é {@code codigoPassageiro}.
     */
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "codigoPassageiro")
    private Passageiro passageiro;

    /**
     * Construtor padrão exigido pelo JPA.
     * Não deve conter lógica de negócio. É utilizado internamente pelo framework.
     */
    public Bilhete() {
    }

    /**
     * Construtor completo para criação de instâncias de {@code Bilhete}.
     *
     * @param idBilhete identificador único do bilhete
     * @param numero    número do bilhete
     * @param assento   assento associado ao bilhete
     * @param bagagem   bagagem vinculada ao bilhete
     * @param passageiro passageiro titular do bilhete
     */
    public Bilhete(Long idBilhete, Integer numero, String assento, Bagagem bagagem, Passageiro passageiro) {
        this.idBilhete = idBilhete;
        this.numero = numero;
        this.assento = assento;
        this.bagagem = bagagem;
        this.passageiro = passageiro;
    }

    /**
     * Retorna o identificador do bilhete.
     *
     * @return id do bilhete
     */
    public Long getIdBilhete() {
        return idBilhete;
    }

    /**
     * Define o identificador do bilhete.
     *
     * @param idBilhete novo id do bilhete
     */
    public void setIdBilhete(Long idBilhete) {
        this.idBilhete = idBilhete;
    }

    /**
     * Retorna o número do bilhete.
     *
     * @return número do bilhete
     */
    public Integer getNumero() {
        return numero;
    }

    /**
     * Define o número do bilhete.
     *
     * @param numero novo número do bilhete
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Retorna o assento associado ao bilhete.
     *
     * @return assento do bilhete
     */
    public String getAssento() {
        return assento;
    }

    /**
     * Define o assento associado ao bilhete.
     *
     * @param assento novo assento do bilhete
     */
    public void setAssento(String assento) {
        this.assento = assento;
    }

    //  private Voo voo;

    public static void main() {

    }


}
