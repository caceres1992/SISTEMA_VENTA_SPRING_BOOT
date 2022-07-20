package com.idat.iluminatik.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Getter
@Setter
public class Person extends IdBaseEntity {
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String email;
    private String dni;
    private String direccion;
    private String celular;
}
