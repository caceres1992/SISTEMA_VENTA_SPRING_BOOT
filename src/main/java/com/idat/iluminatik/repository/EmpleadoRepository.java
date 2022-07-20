package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository  extends JpaRepository<Empleado,Long> {
}