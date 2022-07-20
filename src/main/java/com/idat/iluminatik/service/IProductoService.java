package com.idat.iluminatik.service;

import com.idat.iluminatik.model.Product;
import com.idat.iluminatik.model.ProductoVentas;

import java.util.List;

public interface IProductoService {

    Product createProducto(Product product);
    List<Product> getAllProducto();
    Product getProductoById(Long idProducto);
    Product updateProducto(Long idProducto, Product product);

    void discountProducto(List<ProductoVentas> productoVentas);


    void addCantidadOfProducto(Long idProducto, int cantidad);
}