package com.example.petclinic.infrastructure.outgoing.persistence;

import com.example.petclinic.ports.outgoing.CreateProductPort;
import com.example.petclinic.ports.outgoing.ListProductsPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
class InMemoryProductsRepository implements ListProductsPort, CreateProductPort {

    private final List<Product> products = new ArrayList<>();

    InMemoryProductsRepository() {
            products.add(new Product("Diet Pet Food"));
            products.add(new Product("Diet Cat Food"));
            products.add(new Product("Joint supplement"));
    }

    @Override
    public List<ListProductsPort.Product> list() {
        return products.stream().map(Product::name).map(ListProductsPort.Product::new).toList();
    }

    @Override
    public void create(CreateProductPort.Product product) {
        products.add(new Product(product.name()));
    }

    private record Product(String name) {
    }
}
