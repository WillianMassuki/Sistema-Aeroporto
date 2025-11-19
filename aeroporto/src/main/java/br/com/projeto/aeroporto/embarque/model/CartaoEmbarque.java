package br.com.projeto.aeroporto.embarque.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 * Entidade que representa um cartão de embarque no sistema.
 *
 * <p>
 * Esta classe é mapeada como uma entidade JPA, onde cada instância
 * corresponde a um cartão de embarque emitido para um passageiro,
 * contendo informações como o código do cartão, assento e portão.
 * </p>
 */
@Entity
public class CartaoEmbarque {

    /**
     * Código identificador do cartão de embarque.
     *
     * <p>
     * É a chave primária da entidade e é gerada automaticamente
     * de acordo com a estratégia {@link GenerationType#AUTO}.
     * </p>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String codigoCartaoEmbarque;

    /**
     * Assento atribuído ao passageiro neste cartão de embarque.
     */
    private String assento;

    /**
     * Identificador do portão de embarque associado ao cartão.
     */
    private String idPortao;

    /**
     * Construtor padrão sem argumentos.
     *
     * <p>
     * Necessário para o funcionamento da JPA.
     * </p>
     */
    public CartaoEmbarque() {
    }

    /**
     * Construtor da classe {@code CartaoEmbarque} com código e assento.
     *
     * @param codigoCartaoEmbarque código identificador do cartão de embarque
     * @param assento              assento associado ao cartão de embarque
     */
    public CartaoEmbarque(String codigoCartaoEmbarque, String assento) {
        this.codigoCartaoEmbarque = codigoCartaoEmbarque;
        this.assento = assento;
    }

    /**
     * Obtém o código identificador do cartão de embarque.
     *
     * @return código do cartão de embarque
     */
    public String getCodigoCartaoEmbarque() {
        return codigoCartaoEmbarque;
    }

    /**
     * Define o código identificador do cartão de embarque.
     *
     * @param codigoCartaoEmbarque código do cartão de embarque
     */
    public void setCodigoCartaoEmbarque(String codigoCartaoEmbarque) {
        this.codigoCartaoEmbarque = codigoCartaoEmbarque;
    }

    /**
     * Obtém o assento associado ao cartão de embarque.
     *
     * @return assento do passageiro
     */
    public String getAssento() {
        return assento;
    }

    /**
     * Define o assento associado ao cartão de embarque.
     *
     * @param assento assento do passageiro
     */
    public void setAssento(String assento) {
        this.assento = assento;
    }

    /**
     * Método responsável por realizar a lógica de autorização de passagem.
     *
     * <p>
     * Atualmente não possui implementação. Pode ser utilizado futuramente
     * para aplicar regras de negócio específicas na autorização do embarque
     * (como validação de horário, portão, situação do voo, etc.).
     * </p>
     */
    public void autorizarPassagem() {
        // Lógica de autorização de passagem pode ser implementada aqui.
    }

    /**
     * Obtém o identificador do portão de embarque.
     *
     * @return identificador do portão
     */
    public String getIdPortao() {
        return idPortao;
    }

    /**
     * Define o identificador do portão de embarque.
     *
     * @param idPortao identificador do portão
     */
    public void setIdPortao(String idPortao) {
        this.idPortao = idPortao;
    }

    // Campo comentado para possível relacionamento futuro com a entidade Voo.
    // private Voo voo;
}