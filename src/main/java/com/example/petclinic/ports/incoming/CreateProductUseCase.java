package com.example.petclinic.ports.incoming;

public interface CreateProductUseCase {

    void execute(Command command);

    record Command(String name) {}
}
