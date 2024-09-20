package com.example.petclinic.domain.port.outgoing;

public interface UpdateProductPort {
    void update(Product product);

    record Product(String name, int quantity) {
    }
}
