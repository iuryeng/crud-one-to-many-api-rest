package com.projeto.crudonetomayapirest.web.rest;

import com.projeto.crudonetomayapirest.dominio.Computador;
import com.projeto.crudonetomayapirest.service.dto.ComputadorDTO;
import com.projeto.crudonetomayapirest.service.impl.ComputadorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/computadores")
public class ComputadorResource {

    @Autowired
    private ComputadorServiceImpl computadorServiceimpl;

    @PostMapping
    public  ResponseEntity<ComputadorDTO> createComputador(@RequestBody ComputadorDTO computadorDTO){
       Computador computador = new Computador();
       computadorServiceimpl.createComputador(Computador.from(computadorDTO));
       return  new ResponseEntity<>(ComputadorDTO.from(computador), HttpStatus.CREATED);
    }

    @PutMapping(value = "{id}")
    public  ResponseEntity<ComputadorDTO> updateComputador(@PathVariable Long id, @RequestBody ComputadorDTO computadorDTO){
        Computador computadorUpdate = computadorServiceimpl.updateComputador(id, Computador.from(computadorDTO));
        return new ResponseEntity<>(ComputadorDTO.from(computadorUpdate), HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ComputadorDTO>> getAllComputador(){
        List<Computador> computadores = computadorServiceimpl.getAllComputador();
        List<ComputadorDTO> computadorDTO = computadores.stream().map(ComputadorDTO::from).collect(Collectors.toList());
        return new ResponseEntity<>(computadorDTO,HttpStatus.OK);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ComputadorDTO> getComputadorById(@PathVariable Long id){
        Computador computador = computadorServiceimpl.getComputadorById(id);
        return  new ResponseEntity<>(ComputadorDTO.from(computador), HttpStatus.OK);
    }

    @DeleteMapping(value = "{id}")
    public HttpStatus deleteComputador(@PathVariable long id ) {
        this.computadorServiceimpl.deleteComputador(id);
        return HttpStatus.OK;
    }
}
