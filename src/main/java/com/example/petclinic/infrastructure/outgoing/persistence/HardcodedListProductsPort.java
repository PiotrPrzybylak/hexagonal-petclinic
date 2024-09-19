package com.example.petclinic.infrastructure.outgoing.persistence;

import com.example.petclinic.ports.outgoing.ListProductsPort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HardcodedListProductsPort implements ListProductsPort {
    @Override
    public List<Product> list() {
        return List.of(new Product("Diet Pet Food"), new Product("Diet Cat Food"), new Product("Joint supplement"));
    }
}
