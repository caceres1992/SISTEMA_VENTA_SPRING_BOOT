package com.idat.iluminatik.service.impl;


import com.idat.iluminatik.model.*;
import com.idat.iluminatik.payload.request.RequestProductoVenta;
import com.idat.iluminatik.repository.ProductoRepository;
import com.idat.iluminatik.repository.ProductoVentasRepository;
import com.idat.iluminatik.service.IClienteService;
import com.idat.iluminatik.service.IEmpleadoService;
import com.idat.iluminatik.service.IProductoVentasService;
import com.idat.iluminatik.service.IVentasService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProductoVentasServiceImpl implements IProductoVentasService {

    private ProductoRepository productoRepository;
    private IClienteService clienteService;
    private IEmpleadoService empleadoService;
    private IVentasService ventasService;

    private ProductoVentasRepository productoVentasRepository;
    private ProductoServiceImpl productoService;
    @Override
    public Object createProductoVenta(ProductoVentas productoVentas) {


        if(productoVentas.getPrecio() <= productoVentas.getProduct().getPrice()){
            Product product = productoRepository.findById(productoVentas.getProduct().getId()).orElseThrow(()-> new RuntimeException("no encontrado"));
            productoVentas.setPrecio(product.getPrice());
        }
        log.info("creado producto venta:{}",  productoVentasRepository.save(productoVentas).getId());
        getPrecioTotalByIdVenta(productoVentas.getVentas().getId());

        return null;
    }



    public List<ProductoVentas> saveAllProductoToVenta(RequestProductoVenta productoVentas) {

//            Encontrar al cliente
        Cliente clienteEncontrado = clienteService.findClienteById(productoVentas.getIdCliente());
//            Encontrar al Vendedor
        Empleado empleadoEncontrado =empleadoService.findEmpleadoById(productoVentas.getIdVendedor());

        Long idProducto= Long.valueOf(1);

        List<ProductoVentas> productoVentasList =   productoVentas.getRequestProducto().stream().map(e->{
            ProductoVentas _productoVentas = new ProductoVentas();
            Product productEncontrado = productoRepository.getReferenceById(idProducto);
            _productoVentas.setProduct(productEncontrado);
            _productoVentas.setPrecio(e.getPrice());
            _productoVentas.setCantidad(e.getStock());
            _productoVentas.setPrecioTotal(e.getPrice()*e.getStock());
            return _productoVentas;
        }).collect(Collectors.toList());

        int quantityTotal = productoVentasList.stream().reduce(0,(quantity,product)-> quantity+product.getCantidad(),Integer::sum);
        log.info("lista de detalle venta:{}",quantityTotal);

        Ventas ventas = new Ventas();
        ventas.setSubTotal(productoVentas.getSubTotal());
        ventas.setTotal(productoVentas.getTotal());
        ventas.setCliente(clienteEncontrado);
        ventas.setEmpleado(empleadoEncontrado);
        ventas.setCantidadTotal(quantityTotal);
        ventas.setIGV(productoVentas.getTotal()* .18);
        Ventas _ventagenerada= ventasService.createVentas(ventas);
        log.info("venta generado:{}",_ventagenerada);

        productoService.discountProducto(productoVentasList);
        List<ProductoVentas> generarVenta = new ArrayList<>();
        productoVentasList.forEach(detalle->{
            ProductoVentas _productoVentas = new ProductoVentas();
            _productoVentas.setVentas(ventasService.findVentasById(_ventagenerada.getId()));
            _productoVentas.setProduct(detalle.getProduct());
            _productoVentas.setPrecio(detalle.getPrecio());
            _productoVentas.setCantidad(detalle.getCantidad());
            _productoVentas.setPrecioTotal(detalle.getPrecioTotal());
            generarVenta.add(_productoVentas);
        });
        log.info("arreglo para envianr :{}", productoVentasRepository.saveAll(generarVenta));
        return null;
//        return productoVentasRepository.saveAll(generarVenta);
    }




    public void getPrecioTotalByIdVenta(Long idVenta){

        Ventas ventas = ventasService.findVentasById(idVenta);
        double precioTotal = 0.0;
        double subtotal = 0.0;
        int cantidadItem = 0;

        for (ProductoVentas productoVentas: productoVentasRepository.findAllByVentasId(idVenta)){
            subtotal+= productoVentas.getPrecio() * productoVentas.getCantidad();
            precioTotal+=productoVentas.getPrecio() * productoVentas.getCantidad();
            cantidadItem+= productoVentas.getCantidad();
        }
        ventas.setSubTotal(subtotal);
        ventas.setCantidadTotal(cantidadItem);
        ventas.setTotal((precioTotal*.18)+precioTotal);
        ventasService.createVentas(ventas);

    }



    @Override
    public List<ProductoVentas> getAllProductoVentas() {
        return productoVentasRepository.findAll();
    }
    @Override
    public void deleteProductoOfVentas(Long idProductoVenta){
        ProductoVentas productoVentas = productoVentasRepository.findById(idProductoVenta).orElseThrow(() -> new RuntimeException("no se encontro productoVenta"));
        Long idVenta = productoVentas.getVentas().getId();
        productoService.addCantidadOfProducto(productoVentas.getProduct().getId(),productoVentas.getCantidad());
        productoVentasRepository.deleteById(idProductoVenta);
        getPrecioTotalByIdVenta(idVenta);
    }
}
