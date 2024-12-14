package com.example.petclinic.domain.port.incoming;

public interface CreateProductUseCase {

    void execute(Command command);

    record Command(String name) {
    }
}
