package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.ProductoVentas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoVentasRepository extends JpaRepository<ProductoVentas,Long> {

    List<ProductoVentas> findAllByVentasId(Long id);

}
