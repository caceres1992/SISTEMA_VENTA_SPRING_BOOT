package com.idat.iluminatik.data;


import com.idat.iluminatik.model.*;
import com.idat.iluminatik.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;

public class RunnerData implements CommandLineRunner {
    @Autowired
    private ClienteServiceImpl clienteService;
    @Autowired
    private EmpleadoServiceImpl empleadoService;

    @Autowired
    private CategoryServiceImpl categoriaService;

    @Autowired
    private ProductoServiceImpl productoService;
    @Autowired
    private VentasServiceImpl ventasService;


    @Override
    public void run(String... args) throws Exception {
        Cliente cliente = new Cliente();
        cliente.setName("JASSON");
        cliente.setLastName("CACERES");
        cliente.setEmail("jasson@gmail.com");
        cliente.setAddress("AV LA PAZ 123");
        cliente.setPhone("960503719");
        cliente.setRuc("10472186880");
        cliente.setDni("47218688");
        clienteService.saveCliente(cliente);
        Cliente cliente2 = new Cliente();
        cliente2.setName("Junior");
        cliente2.setLastName("Castro");
        cliente2.setAddress("AV CARLOS IZGUIRE 123");
        cliente2.setEmail("junior@gmail.com");
        cliente2.setPhone("921423349");
        cliente2.setRuc("10234567770");
        cliente2.setDni("23456777");
        clienteService.saveCliente(cliente2);
        Empleado empleado = new Empleado();
        empleado.setDni("20345655");
        empleado.setName("DIEGO");
        empleado.setLastName("MARADONA");
        empleado.setAddress("av las flores 123");
        empleado.setEmail("tapi@gmail.com");
        empleado.setCargo("administrador");
        empleadoService.createEmpleado(empleado);
        Category category = new Category();
        category.setName("camisa");
        category.setDescription("de hilos bla bla");
        categoriaService.createCategoria(category);
        Category category2 = new Category();
        category2.setName("polo");
        category2.setDescription("verano 2022");
        categoriaService.createCategoria(category2);

        Product product = new Product();
        product.setPrice(15.50);
        product.setCategory(category2);
        product.setModelName("CAMISA ELF 2021");
        product.setBrandName("NIKE");
        product.setColor("Verde");
        product.setStock(100);
        product.setSize("large");
        productoService.createProducto(product);

        Product product2 = new Product();
        product2.setPrice(11.50);
        product2.setCategory(category);
        product2.setModelName("CAMISA SNOW 2022");
        product2.setBrandName("J&J");
        product2.setColor("Blanco");
        product2.setStock(150);
        product2.setSize("medium");
        productoService.createProducto(product2);

        Ventas ventas = new Ventas();
        Ventas ventas2 = new Ventas();
        ventas.setCliente(cliente);
        ventas.setEmpleado(empleado);
        ventas.setCreatAt(LocalDate.parse("2022-04-18"));

        ventasService.createVentas(ventas);
        ventas2.setCliente(cliente2);
        ventas2.setEmpleado(empleado);
        ventas2.setCreatAt(LocalDate.parse("2022-06-12"));
        ventasService.createVentas(ventas2);

    }
}