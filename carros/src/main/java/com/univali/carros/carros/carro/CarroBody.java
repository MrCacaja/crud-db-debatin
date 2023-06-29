package com.univali.carros.carros.carro;

public class CarroBody {
    private Integer id_modelo;
    private String nome;
    private Integer renavam;
    private String placa;
    private Double valor;
    private Integer ano;

    public CarroBody() {
    }

    public CarroBody(Integer modelo_id, String nome, Integer renavam, String placa, Double valor, Integer ano) {
        this.id_modelo = modelo_id;
        this.nome = nome;
        this.renavam = renavam;
        this.placa = placa;
        this.valor = valor;
        this.ano = ano;
    }

    public Integer getId_modelo() {
        return id_modelo;
    }

    public void setId_modelo(Integer id_modelo) {
        this.id_modelo = id_modelo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRenavam() {
        return renavam;
    }

    public void setRenavam(Integer renavam) {
        this.renavam = renavam;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
