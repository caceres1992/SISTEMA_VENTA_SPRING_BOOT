package com.idat.iluminatik.controller;


import com.idat.iluminatik.model.Empleado;
import com.idat.iluminatik.service.impl.EmpleadoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados")
@CrossOrigin("*")
public class EmpleadoController {


    @Autowired
    private EmpleadoServiceImpl empleadoService;

    @GetMapping
    public ResponseEntity<List<Empleado>> getAllEmpleado() {
        List<Empleado> empleados = new ArrayList<>();
        empleadoService.findAllEmpleados().forEach(empleados::add);

        if (empleados.isEmpty())
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(empleados, HttpStatus.OK);
    }
}
