package com.idat.iluminatik.controller;


import com.idat.iluminatik.model.Category;
import com.idat.iluminatik.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    ICategoryService categoryService;

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category){
        categoryService.createCategoria(category);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Category>>findAllCategory(){
        return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
    }
    @GetMapping("/{idCategory}")
    public ResponseEntity<Category>findCategoryById(@PathVariable Long idCategory){
        return new ResponseEntity<>(categoryService.findCategoriaById(idCategory),HttpStatus.CREATED);
    }
    @PutMapping("/{idCategory}")
    public ResponseEntity<Category>updateCategory(@PathVariable Long idCategory,@RequestBody Category category){
        return new ResponseEntity<>(categoryService.updateCategoriaById(category,idCategory),HttpStatus.CREATED);
    }
}
