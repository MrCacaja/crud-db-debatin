package com.univali.carros.carros.modelo;

import com.univali.carros.carros.marca.Marca;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

//create table modelo
//        (
//        id integer not null,
//        id_marca integer not null,
//        nome varchar(50) not null,
//        primary key(id),
//        foreign key(id_marca) references marca(id)
//        );

@Entity
public class Modelo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull
    @ManyToOne
    @JoinColumn(name="id_marca", referencedColumnName="id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Marca marca;
    @NotBlank
    @NotNull
    @Size(max=50)
    private String nome;

    public Modelo() { }

    public Modelo(@NotNull Marca marca, @NotNull String nome) {
        this.marca = marca;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Marca getMarca() {
        return marca;
    }

    public void set_marca(Marca marca) {
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
