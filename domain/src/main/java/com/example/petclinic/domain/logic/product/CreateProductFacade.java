package com.example.petclinic.domain.logic.product;

import com.example.petclinic.domain.port.incoming.CreateProductUseCase;
import com.example.petclinic.domain.port.outgoing.CreateProductPort;

public record CreateProductFacade(CreateProductPort createProductPort) implements CreateProductUseCase {


    @Override
    public void execute(Command command) {
        createProductPort.create(new CreateProductPort.Product(command.name()));
    }
}
