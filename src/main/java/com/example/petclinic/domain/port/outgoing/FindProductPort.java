package com.example.petclinic.domain.port.outgoing;

import java.util.Optional;

public interface FindProductPort {

    Optional<Product> findByName(String name);

    record Product(String name, int quantity) {
    }
}
