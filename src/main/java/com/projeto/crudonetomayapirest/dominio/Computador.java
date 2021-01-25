package com.projeto.crudonetomayapirest.dominio;

import com.projeto.crudonetomayapirest.service.dto.ComputadorDTO;
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

    @ManyToOne
    private Colaborador colaborador;

    public static Computador from(ComputadorDTO computadorDTO){
        Computador computador = new Computador();
        computador.setModelo(computadorDTO.getModelo());
        computador.setMarca(computadorDTO.getMarca());
        computador.setServiceTag(computadorDTO.getServiceTag());
        return computador;

    }
}
