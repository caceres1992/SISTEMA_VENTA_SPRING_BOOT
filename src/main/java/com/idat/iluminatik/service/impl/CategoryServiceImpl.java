package com.idat.iluminatik.service.impl;


import com.idat.iluminatik.model.Category;
import com.idat.iluminatik.repository.CategoriaRepository;
import com.idat.iluminatik.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class CategoryServiceImpl implements ICategoryService {


    private CategoriaRepository categoriaRepository;

    @Override
    public void createCategoria(Category category) {
        categoriaRepository.save(category);
    }

    @Override
    public List<Category> findAll() {
        return categoriaRepository.findAll();
    }

    @Override
    public Category findCategoriaById(Long idCategoria) {
        Category category = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("No se encontro categoria"));
        return category;
    }

    @Override
    public Category updateCategoriaById(Category category, Long idCategoria) {
        Category _category = categoriaRepository.findById(idCategoria)
                .orElseThrow(() -> new RuntimeException("No se encontro categoria"));
        _category.setDescription(category.getDescription());
        _category.setName(category.getName());
        categoriaRepository.save(_category);
        return _category;
    }
}
