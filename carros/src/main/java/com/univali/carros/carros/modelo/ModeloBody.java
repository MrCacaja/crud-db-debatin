package com.univali.carros.carros.modelo;

public class ModeloBody {
    private Integer id_marca;
    private String nome;

    public ModeloBody(Integer idMarca, String nome) {
        id_marca = idMarca;
        this.nome = nome;
    }

    public Integer getId_marca() {
        return id_marca;
    }

    public void setId_marca(Integer id_marca) {
        this.id_marca = id_marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ModeloBody() {
    }
}
