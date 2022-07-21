package com.idat.iluminatik.service.impl;


import com.idat.iluminatik.model.Cliente;
import com.idat.iluminatik.repository.ClienteRepository;
import com.idat.iluminatik.service.IClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@Slf4j
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private ClienteRepository clienteRepository;


    @Override
    public void saveCliente(Cliente cliente) {

        clienteRepository.save(cliente);
    }

    @Override
    public Cliente findClienteById(Long idCliente) {
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(()-> new RuntimeException("Cliente no encontrado.."));
        return cliente;
    }

    @Override
    public List<Cliente> findAllClientes() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes;
    }

    @Override
    public Cliente updateCliente(Long idCliente, Cliente cliente) {
        Cliente _cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado.."));

        _cliente.setDni(cliente.getDni());
        _cliente.setRuc(cliente.getRuc());
        _cliente.setPhone(cliente.getPhone());
        _cliente.setAddress(cliente.getAddress());
        _cliente.setLastName(cliente.getLastName());
        _cliente.setEmail(cliente.getEmail());
        _cliente.setName(cliente.getName());

        return clienteRepository.save(_cliente);
    }

    @Override
    public void disableCliente(Long idCliente) {
        Cliente cliente =  clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado.."));
        cliente.setEstado(!cliente.getEstado());
    }

    @Override
    public Cliente findClientByDni(String rucOrDni) {
        Cliente cliente = clienteRepository.findClienteByDni(rucOrDni);
        if(cliente !=null){
            return  cliente;
        }
        return null;
    }

    @Override
    public boolean existClientByDni(String dni) {
        return clienteRepository.existsByDni(dni);
    }


}

