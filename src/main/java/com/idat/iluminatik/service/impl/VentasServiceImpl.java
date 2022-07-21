package com.idat.iluminatik.service.impl;


import com.idat.iluminatik.model.ProductoVentas;
import com.idat.iluminatik.model.Ventas;
import com.idat.iluminatik.repository.ClienteRepository;
import com.idat.iluminatik.repository.EmpleadoRepository;
import com.idat.iluminatik.repository.ProductoVentasRepository;
import com.idat.iluminatik.repository.VentasRepository;
import com.idat.iluminatik.service.IVentasService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class VentasServiceImpl implements IVentasService {

    private VentasRepository ventasRepository;
private ProductoVentasRepository productoVentasRepository;

    @Override
    public Ventas createVentas(Ventas ventas) {
//        Cliente cliente = clienteRepository.findById(ventas.getCliente().getId()).orElseThrow(() -> new RuntimeException("Error al encon trar Cliente"));
//        Empleado empleado = empleadoRepository.findById(ventas.getEmpleado().getId()).orElseThrow(() -> new RuntimeException("Error al encon trar Empleado"));

//        ventas.setCliente(cliente);
//        ventas.setEmpleado(empleado);
//        ventas.setTotal(ventas.getTotal());
//        ventas.setSubTotal(ventas.getSubTotal());
//        ventas.setCantidadTotal(ventas.getCantidadTotal());

        return ventasRepository.save(ventas);
    }

    @Override
    public List<Ventas> ventas() {

        return ventasRepository.findAll();
    }

    @Override
    public Ventas findVentasById(Long idVentas) {
        Ventas ventas = ventasRepository.findById(idVentas)
                .orElseThrow(() -> new RuntimeException("NO se encontro ninguna venta"));
        return ventas;
    }

    @Override
    public Ventas updateVentasById(Long idVentas, Ventas ventas) {
        Ventas _ventas = ventasRepository.findById(idVentas)
                .orElseThrow(() -> new RuntimeException("NO se encontro ninguna venta"));
        _ventas.setCliente(ventas.getCliente());
        _ventas.setCantidadTotal(ventas.getCantidadTotal());
        _ventas.setEmpleado(ventas.getEmpleado());
        _ventas.setCliente(ventas.getCliente());
        ventasRepository.save(_ventas);
        return _ventas;
    }

    @Override
    public void saleCanceled(Long idVenta) {
            Ventas ventas = findVentasById(idVenta);
            ventas.setDespachado(false);
            ventasRepository.save(ventas);


    }


}
