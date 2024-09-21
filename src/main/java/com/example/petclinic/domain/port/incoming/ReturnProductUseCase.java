package com.example.petclinic.domain.port.incoming;

public interface ReturnProductUseCase {
    void execute(Command command);

    record Command(String name) {
    }
}
