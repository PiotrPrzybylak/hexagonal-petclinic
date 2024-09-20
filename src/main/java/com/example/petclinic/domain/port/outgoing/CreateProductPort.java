package com.example.petclinic.domain.port.outgoing;

public interface CreateProductPort {

    void create(Product product);

    record Product(String name) {
    }
}
