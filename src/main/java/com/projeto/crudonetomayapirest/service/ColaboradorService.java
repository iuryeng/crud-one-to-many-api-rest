package com.projeto.crudonetomayapirest.service;

import com.projeto.crudonetomayapirest.dominio.Colaborador;
import com.projeto.crudonetomayapirest.dominio.Computador;

import java.util.List;

public interface ColaboradorService {

    Colaborador createColaborador(Colaborador colaborador);

    Colaborador updateColaborador( Colaborador colaborador);

    List<Colaborador> getAllColaborador();

    Colaborador getColaboradorById(Long colaboradorId);

    Colaborador addComputadorParaColaborador(Long colaboradorId, Long computadorId);

    Colaborador deleteComputadorDeColaborador(Long colaboradorId, Long computadorId);

    void deleteColaborador(Long colaboradorId);


}
