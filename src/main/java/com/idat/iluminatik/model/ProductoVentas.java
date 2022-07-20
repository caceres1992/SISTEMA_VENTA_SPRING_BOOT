package com.idat.iluminatik.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductoVentas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "ventas_ID")
    private Ventas ventas;
    @ManyToOne
    private Product product;
    private double precio;
    private int cantidad;
    private double precioTotal;
}