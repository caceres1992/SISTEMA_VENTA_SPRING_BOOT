package com.idat.iluminatik.service;

import com.idat.iluminatik.model.StockAdd;

import java.util.List;

public interface IStockAddService {

    StockAdd stockAddToProduct(StockAdd stockAdd);

    List<StockAdd> listStockAdd();

}
