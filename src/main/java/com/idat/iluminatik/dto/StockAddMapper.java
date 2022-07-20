package com.idat.iluminatik.dto;


import com.idat.iluminatik.model.Product;
import com.idat.iluminatik.model.StockAdd;
import com.idat.iluminatik.payload.request.RequestStockAdd;
import com.idat.iluminatik.payload.response.ResponseStockAdd;

import java.util.List;
import java.util.stream.Collectors;

public class StockAddMapper {


    public static ResponseStockAdd toResponseStockAdd(StockAdd stockAdd){
        return ResponseStockAdd.builder()
                .id(stockAdd.getId())
                .modelName(stockAdd.getProduct().getModelName())
                .price(stockAdd.getPrice())
                .provider(stockAdd.getProvider())
                .quantity(stockAdd.getQuantity())
                .createAt(stockAdd.getCreateAt())
                .build();
    }

    public static StockAdd toStockAddEntity(RequestStockAdd requestStockAdd, Product product){
        StockAdd stockAdd = new StockAdd();
        stockAdd.setProduct(product);
        stockAdd.setQuantity(requestStockAdd.getQuantity());
        stockAdd.setProvider(requestStockAdd.getProvider());
        stockAdd.setGuideNumber(requestStockAdd.getGuideNumber());
        stockAdd.setPrice(requestStockAdd.getPrice());
        return stockAdd;
    }

    public static List<ResponseStockAdd> toListStockAdd(List<StockAdd> stockAddList){
        return stockAddList.stream().map(StockAddMapper::toResponseStockAdd).collect(Collectors.toList());
    }
}