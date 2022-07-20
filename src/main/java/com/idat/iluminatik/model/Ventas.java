package com.idat.iluminatik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ventas extends IdBaseEntity {
    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Empleado empleado;
    private LocalDate creatAt;
    private int cantidadTotal;
    private double subTotal;
    private double IGV;
    private double total;
    private Boolean despachado;

    @PrePersist
    void prepersit(){
        creatAt = LocalDate.now();
        despachado=true;
    }
}
