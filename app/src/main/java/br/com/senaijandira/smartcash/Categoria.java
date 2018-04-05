package br.com.senaijandira.smartcash;

/**
 * Created by 17170098 on 02/04/2018.
 */

public class Categoria {
    private Integer idCategoria;
    private String nomeCategoria;
    private String descCategoria;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public String getDescCategoria() {
        return descCategoria;
    }

    public void setDescCategoria(String descCategoria) {
        this.descCategoria = descCategoria;
    }

    public Categoria(String nomeCategoria, String descCategoria){
        this.idCategoria = idCategoria;
        this.nomeCategoria = nomeCategoria;
        this.descCategoria = descCategoria;
    }
}
