package com.projeto.crudonetomayapirest.service.dto;

import com.projeto.crudonetomayapirest.dominio.Colaborador;
import com.projeto.crudonetomayapirest.dominio.Computador;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class ColaboradorDTO {
    private Long id;
    private String name;
    private Long CPF;
    private  String funcao;
    private List<Computador> computadores = new ArrayList<>();

    public static ColaboradorDTO from(Colaborador colaborador){
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
        colaboradorDTO.setId(colaborador.getId());
        colaboradorDTO.setName((colaborador.getName()));
        colaboradorDTO.setCPF(colaborador.getCPF());
        colaboradorDTO.setFuncao(colaboradorDTO.getFuncao());
        colaboradorDTO.setComputadores(colaborador.getComputadores());
        return colaboradorDTO;
    }


}
