package com.example.petclinic.domain.port.outgoing;

import java.util.List;

public interface ListProductsPort {

    List<Product> list();

    record Product(String name) {
    }
}
