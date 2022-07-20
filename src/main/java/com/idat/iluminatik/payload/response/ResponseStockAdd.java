package com.idat.iluminatik.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Builder
@Data
public class ResponseStockAdd {
    private Long id;
    private String provider;
    private String modelName;
    private int quantity;
    private double price;
    private LocalDate createAt;
}