package com.idat.iluminatik.service.impl;


import com.idat.iluminatik.model.Empleado;
import com.idat.iluminatik.repository.EmpleadoRepository;
import com.idat.iluminatik.service.IEmpleadoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class EmpleadoServiceImpl  implements IEmpleadoService {

    private EmpleadoRepository empleadoRepository;

    @Override
    public void createEmpleado(Empleado empleado) {
        empleadoRepository.save(empleado);
    }

    @Override
    public Empleado findEmpleadoById(Long idEmpleado) {
        Empleado empleado = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new RuntimeException("No Encontramos al empleado"));
        return empleado;
    }

    @Override
    public List<Empleado> findAllEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado updateEmpleado(Long idEmpleado, Empleado empleado) {
        Empleado _empleado = empleadoRepository.findById(idEmpleado)
                .orElseThrow(() -> new RuntimeException("No Encontramos al empleado"));

        _empleado.setCargo(empleado.getCargo());
        _empleado.setNombre(empleado.getNombre());
        _empleado.setApellidoMaterno(empleado.getApellidoMaterno());
        _empleado.setApellidoPaterno(empleado.getApellidoPaterno());
        _empleado.setCelular(empleado.getCelular());
        _empleado.setDireccion(empleado.getDireccion());
        _empleado.setEmail(empleado.getEmail());
        _empleado.setDni(empleado.getDni());
        return empleadoRepository.save(_empleado);
    }

    @Override
    public void disableEmpleado(Long idEmpleado) {

    }
}