package com.idat.iluminatik.controller;


import com.idat.iluminatik.payload.request.RequestProductoVenta;
import com.idat.iluminatik.service.IEmpleadoService;
import com.idat.iluminatik.service.IProductoService;
import com.idat.iluminatik.service.impl.ClienteServiceImpl;
import com.idat.iluminatik.service.impl.ProductoVentasServiceImpl;
import com.idat.iluminatik.service.impl.VentasServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productoventas")
@CrossOrigin("*")
@Slf4j
public class ProductoVentaController {


    @Autowired
    private ProductoVentasServiceImpl productoVentasService;



    @PostMapping
    ResponseEntity<?> addProductoToVenta(@RequestBody RequestProductoVenta requestProductoVenta){

        productoVentasService.saveAllProductoToVenta(requestProductoVenta);

        return  null;

//        return new ResponseEntity<>(productoVentasService.saveAllProductoToVenta(productoVentasList),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> getProductoVenta(){

        return new ResponseEntity<>(productoVentasService.getAllProductoVentas(), HttpStatus.OK) ;
    }

    @DeleteMapping("/{idProductoVenta}")
    public ResponseEntity<?> deleteProductoVenta(@PathVariable Long idProductoVenta){
        productoVentasService.deleteProductoOfVentas(idProductoVenta);
        return new ResponseEntity<>("SE ELIMINO EXITOSAMENTE",HttpStatus.OK);
    }

}
