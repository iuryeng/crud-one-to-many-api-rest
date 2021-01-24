package com.projeto.crudonetomayapirest.service;

import com.projeto.crudonetomayapirest.dominio.Computador;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ComputadorService {

    Computador createComputador(Computador computador);

    Computador updateComputador(Long computadorId, Computador computador);

    List<Computador> getAllComputador();

    Computador getComputadorById(Long computadorId);

    void deleteComputador(Long computadorId);

}
