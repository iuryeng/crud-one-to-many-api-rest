package com.projeto.crudonetomayapirest.dominio;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="Colaborador")
public class Colaborador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private Long CPF;

    private String funcao;

    @OneToMany(
            cascade = CascadeType.ALL
    )

    @JoinColumn(name = "id_colaborador")
    private List<Computador> computadores = new ArrayList<>();

    public Colaborador(){

    }

    public void addComputador(Computador computador){

    }
}
