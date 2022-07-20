package com.idat.iluminatik.model;

import lombok.Data;

import javax.persistence.Entity;

@Entity
@Data
public class Empleado extends Person {
    private String cargo;
}
