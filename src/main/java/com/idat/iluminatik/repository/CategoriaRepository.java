package com.idat.iluminatik.repository;

import com.idat.iluminatik.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Category,Long> {
}
