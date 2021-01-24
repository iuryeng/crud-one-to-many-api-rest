package com.projeto.crudonetomayapirest.web.rest;

import com.projeto.crudonetomayapirest.dominio.Colaborador;
import com.projeto.crudonetomayapirest.service.dto.ColaboradorDTO;
import com.projeto.crudonetomayapirest.service.impl.ColaboradorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/colaboradores")
public class ColaboradorResource {

    @Autowired
    private ColaboradorServiceImpl colaboradorServiceImpl;

    @PostMapping
    public ResponseEntity<ColaboradorDTO> createColaborador(@RequestBody ColaboradorDTO colaboradorDTO){
        Colaborador colaborador = colaboradorServiceImpl.createColaborador(Colaborador.from(colaboradorDTO));
        return new ResponseEntity<>(ColaboradorDTO.from(colaborador), HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public  ResponseEntity<ColaboradorDTO> updateColaborador(@PathVariable Long id, @RequestBody ColaboradorDTO colaboradorDTO ){
        Colaborador colaborador = colaboradorServiceImpl.updateColaborador(id, Colaborador.from(colaboradorDTO));
        return new ResponseEntity<>(ColaboradorDTO.from(colaborador), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ColaboradorDTO>> getAllColaborador(){
        List<Colaborador> colaboradores = colaboradorServiceImpl.getAllColaborador();
        List<ColaboradorDTO> colaboradorDTOS = colaboradores.stream().map(ColaboradorDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(colaboradorDTOS, HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ColaboradorDTO> getColaboradorById(@PathVariable Long id){
        Colaborador colaborador = colaboradorServiceImpl.getColaboradorById(id);
        return new ResponseEntity<>(ColaboradorDTO.from(colaborador), HttpStatus.OK);
    }

    @PostMapping(value = "{colaboradorId}/computadores/{computadorId}/add")
    public ResponseEntity<ColaboradorDTO> addComputadorParaColaborador(@PathVariable Long colaboradorId, @PathVariable Long computadorId){
        Colaborador colaborador = colaboradorServiceImpl.addComputadorParaColaborador(colaboradorId, computadorId);
        return new ResponseEntity<>(ColaboradorDTO.from(colaborador), HttpStatus.CREATED);
    }

    @DeleteMapping(value = "{colaboradorId}/computadores/{computadorId}/delete")
    public ResponseEntity<ColaboradorDTO> deleteComputadorDeColaborador(@PathVariable Long colaboradorId, @PathVariable Long computadorId){
        Colaborador colaborador = colaboradorServiceImpl.deleteComputadorDeColaborador(colaboradorId, computadorId);
        return new ResponseEntity<>(ColaboradorDTO.from(colaborador), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public HttpStatus deleteColaborador(@PathVariable long id ) {
        this.colaboradorServiceImpl.deleteColaborador(id);
        return HttpStatus.OK;
    }

}
