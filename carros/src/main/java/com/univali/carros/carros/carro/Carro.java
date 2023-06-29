package com.univali.carros.carros.carro;

import com.univali.carros.carros.modelo.Modelo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.Range;

//create table carro
//        (
//        id integer not null,
//        id_modelo integer not null,
//        nome varchar(50) not null,
//        renavam integer not null,
//        placa varchar(7) not null,
//        valor decimal(10, 2) not null,
//        ano year not null,
//        primary key(id),
//        foreign key(id_modelo) references modelo(id)
//        );

@Entity
public class Carro {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_modelo", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Modelo modelo;
    @NotBlank
    @NotNull
    @Size(max=50)
    private String nome;
    @NotNull
    private Integer renavam;
    @NotBlank
    @NotNull
    @Size(max=7)
    private String placa;
    @NotNull
    private Double valor;
    @NotNull
    @Range(max=2023, min=1900)
    private Integer ano;

    public Carro() { }

    public Carro(Modelo modelo, String nome, Integer renavam, String placa, Double valor, Integer ano) {
        this.modelo = modelo;
        this.nome = nome;
        this.renavam = renavam;
        this.placa = placa;
        this.valor = valor;
        this.ano = ano;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
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
