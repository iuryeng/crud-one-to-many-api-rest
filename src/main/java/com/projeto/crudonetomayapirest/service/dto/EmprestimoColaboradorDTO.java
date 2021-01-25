package com.projeto.crudonetomayapirest.service.dto;

import com.projeto.crudonetomayapirest.dominio.Colaborador;
import lombok.Data;



@Data
public class EmprestimoColaboradorDTO {
    private Long id;
    private  String name;

    public static  EmprestimoColaboradorDTO from(Colaborador colaborador){
        EmprestimoColaboradorDTO emprestimoColaboradorDTO = new EmprestimoColaboradorDTO();
        emprestimoColaboradorDTO.setId(colaborador.getId());
        emprestimoColaboradorDTO.setName(colaborador.getName());
        return emprestimoColaboradorDTO;
    }
}
