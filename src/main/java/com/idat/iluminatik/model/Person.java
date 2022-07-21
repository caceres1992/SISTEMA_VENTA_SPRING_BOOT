package com.idat.iluminatik.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
@Getter
@Setter
public class Person extends IdBaseEntity {
    private String name;
    private String lastName;
    private String email;
    private String dni;
    private String address;
    private String phone;
}
