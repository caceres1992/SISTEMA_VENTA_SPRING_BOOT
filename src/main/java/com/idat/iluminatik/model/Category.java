package com.idat.iluminatik.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Category extends IdBaseEntity{
    private String name;
    private String description;
}