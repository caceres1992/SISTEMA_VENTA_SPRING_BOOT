package com.idat.iluminatik.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.PrePersist;

@Entity
@Data
public class Cliente extends Person  {
    private String ruc;
    private Boolean estado;
    @PrePersist
    void prepersit (){
        estado = true;
    }
}
