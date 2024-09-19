package com.example.petclinic.ports.outgoing;

import com.example.petclinic.domain.product.Product;

public interface UpdateProductPort {
    void update(Product product);

    record Product(String name, int quantity) {
    }
}
