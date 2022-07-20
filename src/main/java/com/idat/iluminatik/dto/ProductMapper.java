package com.idat.iluminatik.dto;


import com.idat.iluminatik.model.Category;
import com.idat.iluminatik.model.Product;
import com.idat.iluminatik.payload.request.RequestProducto;
import com.idat.iluminatik.payload.response.ProductResponse;

public class ProductMapper {


    public static ProductResponse toProductResponse(Product product){
        return ProductResponse.builder()

                .idProduct(product.getId())
                .size(product.getSize())
                .color(product.getColor())
                .modelName(product.getModelName())
                .price(product.getPrice())
                .stock(product.getStock())
                .urlImage(product.getUrlImage())
                .idCategory(String.valueOf(product.getCategory().getId()))
                .build();
    }

    public static  Product toProductEntity(RequestProducto requestProducto, Category category){
        Product product= new Product();
        product.setCategory(category);
        product.setId(requestProducto.getIdProduct());
        product.setStock(requestProducto.getStock());
        product.setUrlImage(requestProducto.getUrlImage());
        product.setBrandName(requestProducto.getBrandName());
        product.setModelName(requestProducto.getModelName());
        product.setColor(requestProducto.getColor());
        product.setSize(requestProducto.getSize());
        product.setPrice(requestProducto.getPrice());
        return product;

    }
}

