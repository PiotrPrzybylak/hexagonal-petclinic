package com.example.petclinic.ports.outgoing;

public interface CreateProductPort {

    void create(Product product);

    record Product(String name) {
    }
}
