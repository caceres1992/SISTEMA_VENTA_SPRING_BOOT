package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Product,Long> {

}
