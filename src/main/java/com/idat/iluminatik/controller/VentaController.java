package com.idat.iluminatik.controller;


import com.idat.iluminatik.dto.SaleMapper;
import com.idat.iluminatik.model.Ventas;
import com.idat.iluminatik.payload.response.SaleResponse;
import com.idat.iluminatik.service.impl.VentasServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/sales")
@CrossOrigin("*")
public class VentaController {


    @Autowired
    private VentasServiceImpl ventasService;

    @GetMapping
    public ResponseEntity<List<SaleResponse>> findAllVentas(){
        List<Ventas> ventasList = new ArrayList<>();
        ventasService.ventas().forEach(ventasList::add);

        if(ventasList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>( SaleMapper.toSaleResponseList(ventasList),HttpStatus.OK);

    }


    @PostMapping
    public ResponseEntity<Ventas> createVenta(@RequestBody Ventas ventas){
        return new ResponseEntity<>(ventasService.createVentas(ventas),HttpStatus.CREATED);
    }

}
