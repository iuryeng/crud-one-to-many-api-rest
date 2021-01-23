package com.projeto.crudonetomayapirest.repository;

import com.projeto.crudonetomayapirest.dominio.Computador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComputadorRepository extends JpaRepository<Computador, Long> {
}
