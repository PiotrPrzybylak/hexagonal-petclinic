package com.example.petclinic.domain.product;

import com.example.petclinic.ports.incoming.CreateProductUseCase;
import com.example.petclinic.ports.outgoing.CreateProductPort;

public record CreateProductFacade(CreateProductPort createProductPort) implements CreateProductUseCase {


    @Override
    public void execute(Command command) {
        createProductPort.create(new CreateProductPort.Product(command.name()));
    }
}
