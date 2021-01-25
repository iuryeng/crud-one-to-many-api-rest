package com.projeto.crudonetomayapirest.service.dto;

import com.projeto.crudonetomayapirest.dominio.Computador;
import lombok.Data;

import java.util.Objects;

@Data
public class ComputadorDTO {

    private Long id;

    private String modelo;

    private String marca;

    private Long serviceTag;

    private EmprestimoColaboradorDTO emprestimoColaboradorDTO;

    public static ComputadorDTO from(Computador computador){
        ComputadorDTO computadorDTO = new ComputadorDTO();
        computadorDTO.setId(computador.getId());
        computadorDTO.setModelo(computador.getModelo());
        computadorDTO.setMarca(computador.getMarca());
      computadorDTO.setServiceTag(computador.getServiceTag());
        if(Objects.nonNull(computador.getColaborador())){
            computadorDTO.setEmprestimoColaboradorDTO(EmprestimoColaboradorDTO.from(computador.getColaborador()));
        }

        return  computadorDTO;
    }
}
