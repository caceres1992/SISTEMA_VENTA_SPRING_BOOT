package com.idat.iluminatik.service;

import com.idat.iluminatik.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    void createEmpleado(Empleado empleado);
    Empleado findEmpleadoById(Long idEmpleado);
    List<Empleado> findAllEmpleados();
    Empleado updateEmpleado(Long idEmpleado,Empleado empleado);
    void disableEmpleado(Long idEmpleado);
}
