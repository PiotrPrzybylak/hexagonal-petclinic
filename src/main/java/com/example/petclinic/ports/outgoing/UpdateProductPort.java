package com.example.petclinic.ports.outgoing;

public interface UpdateProductPort {
    void update(Product product);

    record Product(String name, int quantity) {
    }
}
