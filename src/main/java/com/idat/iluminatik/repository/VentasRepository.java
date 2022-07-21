package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.ProductoVentas;
import com.idat.iluminatik.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentasRepository extends JpaRepository<Ventas,Long> {

}
