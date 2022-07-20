package com.idat.iluminatik.service;

import com.idat.iluminatik.model.Category;

import java.util.List;

public interface ICategoryService {

    void createCategoria(Category category);
    List<Category> findAll();
    Category findCategoriaById(Long idCategoria);
    Category updateCategoriaById(Category category, Long idCategoria);

}
