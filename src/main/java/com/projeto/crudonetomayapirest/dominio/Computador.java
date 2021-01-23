package com.projeto.crudonetomayapirest.dominio;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="Computador")
public class Computador {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String modelo;

    private String marca;

    private Long serviceTag;

}
