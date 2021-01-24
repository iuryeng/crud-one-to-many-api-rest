package com.projeto.crudonetomayapirest.service.impl;

import com.projeto.crudonetomayapirest.dominio.Colaborador;
import com.projeto.crudonetomayapirest.dominio.Computador;
import com.projeto.crudonetomayapirest.exception.ColaboradorNotFoundException;
import com.projeto.crudonetomayapirest.repository.ColaboradorRepository;
import com.projeto.crudonetomayapirest.service.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ComputadorServiceImpl computadorServiceImpl;

    @Override
    public Colaborador createColaborador(Colaborador colaborador) {
        return colaboradorRepository.save(colaborador);
    }

    @Override
    public Colaborador updateColaborador(Long colaboradorId, Colaborador colaborador) {
        Colaborador updateColaborador = getColaboradorById(colaboradorId);
        updateColaborador.setCPF(colaborador.getCPF());
        updateColaborador.setFuncao(colaborador.getFuncao());
        updateColaborador.setName(colaborador.getName());
        return updateColaborador;
    }

    @Override
    public List<Colaborador> getAllColaborador() {
       return StreamSupport.stream(colaboradorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Colaborador getColaboradorById(Long colaboradorId) {
        Optional<Colaborador> colaborador = colaboradorRepository.findById(colaboradorId);

        if(colaborador.isEmpty()){
            throw new ColaboradorNotFoundException(colaboradorId);
        }else{
            return colaborador.get();
        }
    }

    @Override
    public Colaborador addComputadorParaColaborador(Long colaboradorId, Long computadorId) {
        Colaborador colaborador = getColaboradorById(colaboradorId);
        Computador computador = computadorServiceImpl.getComputadorById(computadorId);
        colaborador.addComputador(computador);
        return colaborador;

    }

    @Override
    public Colaborador deleteComputadorDeColaborador(Long colaboradorId, Long computadorId) {
        Colaborador colaborador = getColaboradorById(colaboradorId);
        Computador computador = computadorServiceImpl.getComputadorById(computadorId);
        colaborador.deleteComputador(computador);
        return  colaborador;
    }

    @Override
    public void deleteColaborador(Long colaboradorId) {

        Optional<Colaborador> colaborador  = colaboradorRepository.findById(colaboradorId);

        if(colaborador.isEmpty()){
            throw new ColaboradorNotFoundException(colaboradorId);
        }else{
            this.colaboradorRepository.delete(colaborador.get());
        }
    }
}
