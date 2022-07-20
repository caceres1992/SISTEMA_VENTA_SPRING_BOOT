package com.idat.iluminatik.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@Data
public class Product extends IdBaseEntity{

    private String brandName;
    private String modelName;
    private int stock;
    private double price;
    private String size;
    private String color;
    private String urlImage;
    @ManyToOne
    private Category category;
    private boolean status;
}

