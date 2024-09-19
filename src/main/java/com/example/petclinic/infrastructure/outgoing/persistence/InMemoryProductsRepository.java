package com.example.petclinic.infrastructure.outgoing.persistence;

import com.example.petclinic.ports.outgoing.CreateProductPort;
import com.example.petclinic.ports.outgoing.FindProductPort;
import com.example.petclinic.ports.outgoing.ListProductsPort;
import com.example.petclinic.ports.outgoing.UpdateProductPort;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
class InMemoryProductsRepository implements ListProductsPort, CreateProductPort, FindProductPort, UpdateProductPort {

    private final List<Product> products = new ArrayList<>();

    InMemoryProductsRepository() {
        products.add(new Product("Diet Pet Food", 100));
        products.add(new Product("Diet Cat Food", 200));
        products.add(new Product("Joint supplement", 5));
    }

    @Override
    public List<ListProductsPort.Product> list() {
        return products.stream().map(Product::name).map(ListProductsPort.Product::new).toList();
    }

    @Override
    public void create(CreateProductPort.Product product) {
        products.add(new Product(product.name(), 0));
    }

    @Override
    public Optional<FindProductPort.Product> findByName(String name) {
        return products.stream().filter(product -> product.name.equals(name)).map(p -> new FindProductPort.Product(p.name, p.quantity)).findFirst();
    }

    @Override
    public void update(UpdateProductPort.Product product) {
        Product productToUpdate = products.stream().filter(p -> p.name.equals(product.name())).findFirst().orElseThrow();
        products.remove(productToUpdate);
        products.add(new Product(product.name(), product.quantity()));
    }

    private record Product(String name, int quantity) {
    }
}
