package com.example.petclinic.ports.outgoing;

public interface ProductBoughtNotifier {

    void notify(Product product);

    record Product(String name) {
    }
}
