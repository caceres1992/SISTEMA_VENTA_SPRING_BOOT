package com.idat.iluminatik.dto;


import com.idat.iluminatik.model.Ventas;
import com.idat.iluminatik.payload.response.SaleResponse;

import java.util.List;
import java.util.stream.Collectors;

public class SaleMapper {


    public static SaleResponse toSaleResponse(Ventas sale) {
        return SaleResponse.builder()
                .idVenta(sale.getId())
                .fullNameClient(sale.getCliente().getApellidoPaterno()+" "+sale.getCliente().getApellidoMaterno()+", "+ sale.getCliente().getNombre())
                .status(sale.getDespachado())
                .documentDniClient(sale.getCliente().getDni())
                .documentRucClient(sale.getCliente().getRuc())
                .creatAt(sale.getCreatAt())
                .build();
    }

    public static List<SaleResponse> toSaleResponseList(List<Ventas> sale){
        return sale.stream().map(SaleMapper::toSaleResponse).collect(Collectors.toList());
    }

}
