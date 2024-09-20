package com.example.petclinic.domain.port.outgoing;

public interface ProductBoughtNotifier {

    void notify(Product product);

    record Product(String name) {
    }
}
