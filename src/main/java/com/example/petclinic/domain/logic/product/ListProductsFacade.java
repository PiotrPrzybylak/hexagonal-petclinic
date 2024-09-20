package com.example.petclinic.domain.logic.product;

import com.example.petclinic.domain.port.incoming.ListProductsUseCase;
import com.example.petclinic.domain.port.outgoing.ListProductsPort;

import java.util.List;

public record ListProductsFacade(ListProductsPort listProductsPort) implements ListProductsUseCase {

    @Override
    public List<Product> list() {
        return listProductsPort.list().stream().map(ListProductsPort.Product::name).map(Product::new).toList();
    }
}
