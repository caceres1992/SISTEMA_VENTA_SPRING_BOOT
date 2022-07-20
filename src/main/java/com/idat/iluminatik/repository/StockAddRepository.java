package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.StockAdd;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockAddRepository  extends JpaRepository<StockAdd,Long> {
}