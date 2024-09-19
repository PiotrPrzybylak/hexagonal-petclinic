package com.example.petclinic.ports.incoming;

public interface BuyProductUseCase {

    void execute(Command command);

    record Command(String name) {
    }
}
