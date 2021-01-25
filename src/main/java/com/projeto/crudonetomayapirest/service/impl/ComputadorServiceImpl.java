package com.projeto.crudonetomayapirest.service.impl;

import com.projeto.crudonetomayapirest.dominio.Computador;
import com.projeto.crudonetomayapirest.exception.ComputadorNotFoundException;
import com.projeto.crudonetomayapirest.repository.ComputadorRepository;
import com.projeto.crudonetomayapirest.service.ComputadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ComputadorServiceImpl implements ComputadorService {

    @Autowired
    private ComputadorRepository computadorRepository;

    @Override
    public Computador createComputador(Computador computador) {
        return computadorRepository.save(computador);
    }


    @Override
    public Computador updateComputador(Long computadorId, Computador computador) {

        Computador updateComputador = getComputadorById(computadorId);
        updateComputador.setServiceTag(computador.getServiceTag());
        updateComputador.setMarca(computador.getMarca());
        updateComputador.setModelo(computador.getModelo());
        updateComputador.setColaborador(computador.getColaborador());
        updateComputador.setId(computador.getId());

        return updateComputador;

    }

    @Override
    public List<Computador> getAllComputador() {
        return StreamSupport.stream(computadorRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public Computador getComputadorById(Long computadorId) {
        Optional<Computador> computador = computadorRepository.findById(computadorId);

        if(computador.isEmpty()){
            throw new ComputadorNotFoundException(computadorId);
        }else{
            return computador.get();
        }
    }

    @Override
    public void deleteComputador(Long computadorId) {
        Optional<Computador> computador = computadorRepository.findById(computadorId);

        if(computador.isEmpty()){
            throw new ComputadorNotFoundException(computadorId);
        }else{
            this.computadorRepository.delete(computador.get());
        }

    }
}
