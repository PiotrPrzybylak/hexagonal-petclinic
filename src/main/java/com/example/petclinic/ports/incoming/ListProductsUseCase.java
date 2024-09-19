package com.example.petclinic.ports.incoming;

import java.util.List;

public interface ListProductsUseCase {

    List<Product> list();

    record Product(String name) {
    }
}
