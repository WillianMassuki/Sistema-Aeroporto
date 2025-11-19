package br.com.projeto.aeroporto.comunicacao.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

/**
 * Representa uma mensagem trocada no sistema.
 *
 * <p>
 * Pode ser utilizada como conteúdo de uma {@link Informacao} ou para
 * registrar comunicações entre funcionários, sistemas ou passageiros.
 * </p>
 */
@Entity
public class Mensagem {

    /**
     * Identificador único da mensagem.
     *
     * <p>
     * Pode ser um valor gerado pela aplicação (por exemplo, um UUID em formato
     * de {@code String}).
     * </p>
     */
    @Id
    private String idMensagem;

    /**
     * Remetente da mensagem.
     *
     * <p>
     * Pode ser o nome de um usuário, um identificador de sistema ou outro
     * valor que represente quem enviou a mensagem.
     * Campo obrigatório.
     * </p>
     */
    @Column(nullable = false)
    private String remetente;

    /**
     * Destinatário da mensagem.
     *
     * <p>
     * Pode ser o nome de um usuário, grupo ou sistema que deve receber a
     * mensagem.
     * Campo obrigatório.
     * </p>
     */
    @Column(nullable = false)
    private String destinatario;

    /**
     * Conteúdo textual da mensagem.
     *
     * <p>
     * Representa o corpo da mensagem, como o texto do aviso ou da comunicação.
     * Campo obrigatório.
     * </p>
     */
    @Column(nullable = false)
    private String conteudo;

    /**
     * Data e hora em que a mensagem foi registrada ou enviada.
     *
     * <p>
     * Campo obrigatório, utilizado para rastreamento e ordenação temporal
     * das mensagens.
     * </p>
     */
    @Column(nullable = false)
    private LocalDateTime dataHora;

    /**
     * Retorna o identificador da mensagem.
     *
     * @return id da mensagem
     */
    public String getIdMensagem() {
        return idMensagem;
    }

    /**
     * Define o identificador da mensagem.
     *
     * @param idMensagem novo identificador da mensagem
     */
    public void setIdMensagem(String idMensagem) {
        this.idMensagem = idMensagem;
    }

    /**
     * Retorna o remetente da mensagem.
     *
     * @return remetente da mensagem
     */
    public String getRemetente() {
        return remetente;
    }

    /**
     * Define o remetente da mensagem.
     *
     * @param remetente novo remetente da mensagem
     */
    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    /**
     * Retorna o destinatário da mensagem.
     *
     * @return destinatário da mensagem
     */
    public String getDestinatario() {
        return destinatario;
    }

    /**
     * Define o destinatário da mensagem.
     *
     * @param destinatario novo destinatário da mensagem
     */
    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    /**
     * Retorna o conteúdo da mensagem.
     *
     * @return texto da mensagem
     */
    public String getConteudo() {
        return conteudo;
    }

    /**
     * Define o conteúdo da mensagem.
     *
     * @param conteudo novo texto da mensagem
     */
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    /**
     * Retorna a data e hora da mensagem.
     *
     * @return data/hora da mensagem
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    /**
     * Define a data e hora da mensagem.
     *
     * @param dataHora nova data/hora da mensagem
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}