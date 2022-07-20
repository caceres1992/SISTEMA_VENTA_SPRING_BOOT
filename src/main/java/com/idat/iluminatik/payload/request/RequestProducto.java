package com.idat.iluminatik.payload.request;

import lombok.Data;

@Data
public class RequestProducto {
    private Long idProduct;
    private String brandName;
    private String modelName;
    private String color;
    private double price;
    private String size;
    private int stock;
    private String urlImage;
    private String idCategory;
}