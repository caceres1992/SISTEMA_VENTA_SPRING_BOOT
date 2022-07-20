package com.idat.iluminatik.payload.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SaleResponse {

    private Long idVenta;
    private String fullNameClient;
    private String documentDniClient;
    private String documentRucClient;
    private LocalDate creatAt;
    private Boolean status;
}

