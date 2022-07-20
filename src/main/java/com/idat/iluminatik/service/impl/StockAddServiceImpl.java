package com.idat.iluminatik.service.impl;


import com.idat.iluminatik.model.Product;
import com.idat.iluminatik.model.StockAdd;
import com.idat.iluminatik.repository.StockAddRepository;
import com.idat.iluminatik.service.IProductoService;
import com.idat.iluminatik.service.IStockAddService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StockAddServiceImpl implements IStockAddService {

    private IProductoService productoService;
    private StockAddRepository stockAddRepository;

    @Override
    public StockAdd stockAddToProduct(StockAdd stockAdd) {
        Product product = productoService.getProductoById(stockAdd.getProduct().getId());
        product.setStock(product.getStock() + stockAdd.getQuantity());
        productoService.createProducto(product);
        return  stockAddRepository.save(stockAdd);
    }

    @Override
    public List<StockAdd> listStockAdd() {
        return stockAddRepository.findAll();
    }
}
