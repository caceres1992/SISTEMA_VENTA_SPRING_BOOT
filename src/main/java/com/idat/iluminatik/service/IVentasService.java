package com.idat.iluminatik.service;

import com.idat.iluminatik.model.Ventas;

import java.util.List;

public interface IVentasService {

    Ventas createVentas(Ventas ventas);
    List<Ventas> ventas();
    Ventas findVentasById(Long idVentas);
    Ventas updateVentasById(Long idVentas,Ventas ventas);
}
