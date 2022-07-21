package com.idat.iluminatik.controller;

import com.idat.iluminatik.dto.ProductMapper;
import com.idat.iluminatik.model.Category;
import com.idat.iluminatik.model.Product;
import com.idat.iluminatik.payload.request.RequestProducto;
import com.idat.iluminatik.payload.response.ProductResponse;
import com.idat.iluminatik.repository.CategoriaRepository;
import com.idat.iluminatik.service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {


    @Autowired
    private IProductoService productoService;
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Product>> getAllProductos(){
        List<Product> productList = new ArrayList<>();
        productoService.getAllProducto().forEach(productList::add);
        if(productList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(productList,HttpStatus.OK);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product>getProductById(@PathVariable Long idProduct){
        Product product = productoService.getProductoById(idProduct);
        if(product!=null){
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);


    }
    @PostMapping
    public ResponseEntity<ProductResponse> addProduct(@RequestBody RequestProducto requestProducto){
        Category category = categoriaRepository.getReferenceById(Long.parseLong(requestProducto.getIdCategory()));

        return new ResponseEntity<>( ProductMapper.toProductResponse(
                productoService.createProducto(ProductMapper.toProductEntity(requestProducto,category))), HttpStatus.CREATED);
    }

    @PutMapping("/{idProduct}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long idProduct ,@RequestBody RequestProducto requestProducto){
        Category category = categoriaRepository.getReferenceById(Long.parseLong(requestProducto.getIdCategory()));
//        return new ResponseEntity<>()
        return new ResponseEntity<>( ProductMapper.toProductResponse
                (productoService.updateProducto(idProduct,ProductMapper.toProductEntity(requestProducto,category))),HttpStatus.CREATED);
    }
}
