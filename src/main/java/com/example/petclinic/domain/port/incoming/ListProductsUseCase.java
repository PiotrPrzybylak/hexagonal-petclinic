package com.example.petclinic.domain.port.incoming;

import java.util.List;

public interface ListProductsUseCase {

    List<Product> list();

    record Product(String name) {
    }
}
