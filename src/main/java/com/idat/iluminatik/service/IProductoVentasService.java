package com.idat.iluminatik.service;

import com.idat.iluminatik.model.ProductoVentas;

import java.util.List;

public interface IProductoVentasService {



    Object createProductoVenta(ProductoVentas productoVentas);

    List<ProductoVentas> getAllProductoVentas();
    void deleteProductoOfVentas(Long idProductoVenta);

}
