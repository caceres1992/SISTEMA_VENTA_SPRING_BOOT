package com.idat.iluminatik.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestStockAdd {
    private Long idProduct;
    private String guideNumber;
    private String provider;
    private Double price;
    private int quantity;
}
