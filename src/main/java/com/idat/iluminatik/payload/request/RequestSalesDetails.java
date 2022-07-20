package com.idat.iluminatik.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestSalesDetails {
    private Long idVenta;
    private String fullNameClient;
    private String documentClient;
    private String creatAt;
    private Boolean status;

}
