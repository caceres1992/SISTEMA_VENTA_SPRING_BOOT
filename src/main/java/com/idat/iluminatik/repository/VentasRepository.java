package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas,Long> {
}
