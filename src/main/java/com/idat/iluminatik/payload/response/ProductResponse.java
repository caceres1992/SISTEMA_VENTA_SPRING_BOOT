package com.idat.iluminatik.payload.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductResponse {
    private Long idProduct;
    private String modelName;
    private int stock;
    private double price;
    private String size;
    private String color;
    private String urlImage;
    private String idCategory;
}
