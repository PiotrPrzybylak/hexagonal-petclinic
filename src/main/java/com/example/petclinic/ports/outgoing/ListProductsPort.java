package com.example.petclinic.ports.outgoing;

import java.util.List;

public interface ListProductsPort {

    List<Product> list();

    record Product(String name) {
    }
}
