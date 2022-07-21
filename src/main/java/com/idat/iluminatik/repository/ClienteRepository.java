package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    Cliente findClienteByDni(String dniOrRuc);
    Boolean existsByDni(String dni);

}
