package com.idat.iluminatik.service;

import com.idat.iluminatik.model.Cliente;

import java.util.List;

public interface IClienteService {

    void saveCliente(Cliente cliente);
    Cliente findClienteById(Long idCliente);
    List<Cliente> findAllClientes();
    Cliente updateCliente(Long idCliente,Cliente cliente);
    void disableCliente(Long idCliente);

    Cliente findClientByDni(String rucOrDni);

    boolean existClientByDni(String dni);

}
