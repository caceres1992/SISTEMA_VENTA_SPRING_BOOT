package com.idat.iluminatik.controller;


import com.idat.iluminatik.dto.StockAddMapper;
import com.idat.iluminatik.model.Product;
import com.idat.iluminatik.payload.request.RequestStockAdd;
import com.idat.iluminatik.payload.response.ResponseStockAdd;
import com.idat.iluminatik.service.IProductoService;
import com.idat.iluminatik.service.IStockAddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockAdd")
@CrossOrigin("*")
public class StockAddController {

    @Autowired
    private IProductoService productoService;
    @Autowired
    private IStockAddService stockAddService;

    @GetMapping
    public ResponseEntity<List<ResponseStockAdd>> listStockProduct(){
        return new ResponseEntity<>(StockAddMapper.toListStockAdd(stockAddService.listStockAdd()), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<ResponseStockAdd> addStockToProduct
            (@RequestBody RequestStockAdd requestStockAdd){
        Product productFound=productoService.getProductoById(requestStockAdd.getIdProduct());
        return new ResponseEntity<>(     StockAddMapper.toResponseStockAdd(stockAddService.stockAddToProduct
                (StockAddMapper.toStockAddEntity(requestStockAdd,productFound))), HttpStatus.CREATED);
    }
}
