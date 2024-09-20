package com.example.petclinic.domain.port.incoming;

public interface BuyProductUseCase {

    void execute(Command command);

    record Command(String name) {
    }
}
