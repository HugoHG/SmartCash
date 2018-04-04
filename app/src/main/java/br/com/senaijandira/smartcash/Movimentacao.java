package br.com.senaijandira.smartcash;

/**
 * Created by 17170098 on 21/03/2018.
 */

public class Movimentacao {
    private Integer idMovimentacao;
    private String receita_despesa;
    private String mes;
    private Integer idCategoria;
    private String nomeMovimentacao;
    private String descricao;
    private Integer ano;


    public Integer getIdMovimentacao() {
        return idMovimentacao;
    }

    public void setIdMovimentacao(Integer idMovimentacao) {
        this.idMovimentacao = idMovimentacao;
    }

    public String getReceita_despesa() {
        return receita_despesa;
    }

    public void setReceita_despesa(String receita_despesa) {
        this.receita_despesa = receita_despesa;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeMovimentacao() {
        return nomeMovimentacao;
    }

    public void setNomeMovimentacao(String nomeMovimentacao) {
        this.nomeMovimentacao = nomeMovimentacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
