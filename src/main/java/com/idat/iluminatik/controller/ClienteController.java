package com.idat.iluminatik.controller;


import com.idat.iluminatik.model.Cliente;
import com.idat.iluminatik.service.impl.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/clients")
@CrossOrigin("*")
public class ClienteController {


    @Autowired
    private ClienteServiceImpl clienteService;
    @GetMapping()
    public ResponseEntity<List<Cliente>> getAllClientes(){
        List<Cliente> clientes = new ArrayList<>();
        clienteService.findAllClientes().forEach(clientes::add);
        if(clientes.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }
    @GetMapping("/{idCliente}")
    public ResponseEntity<Cliente>getClienteById(Long idCliente){
        Cliente cliente = clienteService.findClienteById(idCliente);
        if(cliente !=null)
            return new ResponseEntity<>(cliente,HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @PostMapping
    public ResponseEntity<String> createCliente(@RequestBody Cliente cliente){
        if(cliente.equals(null))
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        clienteService.saveCliente(cliente);
        return new ResponseEntity<>("Successful ".concat(cliente.getName()),HttpStatus.CREATED);
    }
    @PutMapping(path = "/update/{idCliente}")
    public ResponseEntity<Cliente> updateClienteById(@RequestBody Cliente cliente,@PathVariable Long idCliente){
        clienteService.updateCliente(idCliente,cliente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PatchMapping("disable/{idCliente}")
    public ResponseEntity<?> disableClienteById(@PathVariable Long idCliente){
        Map<String,Object> resp = new HashMap<>();
        if(idCliente!=null){
            resp.put("msg","Cliente fue desabilitado");
            clienteService.disableCliente(idCliente);
        }else {
            resp.put("msg","No pudo realizar la operacion");
            return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @GetMapping("/document/{dni}")
    public ResponseEntity<?>findClientByRucOrDni(@PathVariable String dni) {
        Map<String, Object> resp = new HashMap<>();
        Cliente cliente = clienteService.findClientByDni(dni);
        if (cliente != null) {
            return new ResponseEntity<>(cliente, HttpStatus.OK);
        } else {
            resp.put("msg", "No se encontro el cliente con el dni o ruc" + dni);
            return new ResponseEntity<>("No hay clientes", HttpStatus.BAD_GATEWAY);
        }
    }



}
