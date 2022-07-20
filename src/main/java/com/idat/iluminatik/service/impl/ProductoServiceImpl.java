package com.idat.iluminatik.service.impl;


import com.idat.iluminatik.exception.InvalidSaleException;
import com.idat.iluminatik.model.Product;
import com.idat.iluminatik.model.ProductoVentas;
import com.idat.iluminatik.repository.ProductoRepository;
import com.idat.iluminatik.service.IProductoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class ProductoServiceImpl  implements IProductoService {

    private ProductoRepository productoRepository;

    @Override
    public Product createProducto(Product product) {
        String imageDefault = "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/No-Image-Placeholder.svg/1665px-No-Image-Placeholder.svg.png";
        if(product.getUrlImage() == null){
            product.setUrlImage(imageDefault);
        }
        return productoRepository.save(product);
    }

    @Override
    public List<Product> getAllProducto() {
        return productoRepository.findAll();
    }

    @Override
    public Product getProductoById(Long idProducto) {
        Product product = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        return product;
    }

    @Override
    public Product updateProducto(Long idProducto, Product product) {
        Product _product = productoRepository.findById(idProducto)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        _product.setBrandName(product.getBrandName());
        _product.setCategory(product.getCategory());
        _product.setModelName(product.getModelName());
        _product.setUrlImage(product.getUrlImage());
        _product.setSize(product.getSize());
        _product.setPrice(product.getPrice());
        productoRepository.save(_product);
        log.info("product:{}", _product);
        return _product;
    }


    @Override
    public void discountProducto(List<ProductoVentas> productoVentas) {
        String stockInsuficiente = "El Producto con ID %s no cuenta con el stock necesario para realizar la venta. Stock Disponible: %d";
        productoVentas.forEach(ventaRealizada->{
            Product productEncontrado = getProductoById(ventaRealizada.getProduct().getId());
            if (productEncontrado.getStock() < ventaRealizada.getCantidad() || productEncontrado.getStock() == 0)
                throw new InvalidSaleException(String.format(stockInsuficiente, ventaRealizada.getId(), ventaRealizada.getCantidad()));

            productEncontrado.setStock( productEncontrado.getStock() - ventaRealizada.getCantidad());
            if(productEncontrado.getStock() == 0) productEncontrado.setStatus(false);
            productoRepository.save(productEncontrado);
        });
    }

    @Override
    public void addCantidadOfProducto(Long idProducto, int cantidad) {
        Product product = productoRepository.findById(idProducto).orElse(null);
        product.setStock(product.getStock()+cantidad);
        productoRepository.save(product);
        log.info("descontado producto a pro :{}", product);

    }
}

