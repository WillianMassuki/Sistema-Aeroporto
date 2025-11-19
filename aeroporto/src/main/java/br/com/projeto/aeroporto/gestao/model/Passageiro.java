package br.com.projeto.aeroporto.gestao.model;

import br.com.projeto.aeroporto.comunicacao.model.Informacao;
import jakarta.persistence.*;

/**
 * Representa um passageiro no sistema.
 *
 * A entidade {@code Passageiro} armazena dados básicos de identificação
 * do passageiro, como nome, documento e número de cartão.
 */
@Entity
public class Passageiro {

    /**
     * Identificador único do passageiro.
     * Gerado automaticamente pelo provedor JPA.

     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigoPassageiro;

    /**
     * Nome completo do passageiro.
     */
    private String nome;

    /**
     * Documento de identificação do passageiro.
     * Pode representar, por exemplo, CPF, RG ou passaporte,
     * dependendo das regras de negócio do sistema.
     */
    private String documento;

    /**
     * Número do cartão associado ao passageiro.
     * Pode ser utilizado para pagamento, programa de milhas ou
     * identificação em sistemas de fidelidade.
     */
    @Column
    private String numeroCartao;

    /**
     * Construtor padrão exigido pelo JPA.
     * Não deve conter lógica de negócio.
     */
    public Passageiro() {
    }

    /**
     * Construtor completo para criação de instâncias de {@code Passageiro}.
     *
     * @param codigoPassageiro identificador do passageiro
     * @param nome             nome do passageiro
     * @param documento        documento de identificação do passageiro
     * @param numeroCartao     número do cartão do passageiro
     */
    public Passageiro(Long codigoPassageiro, String nome, String documento, String numeroCartao) {
        this.codigoPassageiro = codigoPassageiro;
        this.nome = nome;
        this.documento = documento;
        this.numeroCartao = numeroCartao;
    }

    /**
     * Retorna o código (id) do passageiro.
     *
     * @return identificador do passageiro
     */
    public Long getCodigoPassageiro() {
        return codigoPassageiro;
    }

    /**
     * Define o código (id) do passageiro.
     *
     * @param codigoPassageiro novo identificador do passageiro
     */
    public void setCodigoPassageiro(Long codigoPassageiro) {
        this.codigoPassageiro = codigoPassageiro;
    }

    /**
     * Retorna o nome do passageiro.
     *
     * @return nome do passageiro
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do passageiro.
     *
     * @param nome novo nome do passageiro
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o documento do passageiro.
     *
     * @return documento do passageiro
     */
    public String getDocumento() {
        return documento;
    }

    /**
     * Define o documento do passageiro.
     *
     * @param documento novo documento do passageiro
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     * Retorna o número do cartão do passageiro.
     *
     * @return número do cartão
     */
    public String getNumeroCartao() {
        return numeroCartao;
    }


    /**
     * Define o número do cartão do passageiro.
     *
     * @param numeroCartao novo número do cartão
     */
    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }


    /**
     * Realiza a compra de um bilhete para o passageiro.
     * Método privado que, no futuro, pode conter a lógica de compra
     * de bilhetes (validações, chamadas a serviços, etc.).
     */
    private void comprarBilhete() {

    }


    /**
     * Recebe uma notificação para o passageiro.
     *
     * @param info objeto contendo as informações da notificação
     * @return texto de resposta ou confirmação da notificação
     */
    public String receberNotificacao(Informacao info) {

        return "";
    }
}
