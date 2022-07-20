package com.idat.iluminatik.payload.request;

import lombok.Data;

import java.util.List;

@Data
public class RequestProductoVenta {
    private Long idCliente;
    private Long idVendedor;
    private List<RequestProducto> requestProducto;
    private double subTotal;
    private double total;
}
