package com.example.petclinic.domain.product;

import com.example.petclinic.ports.incoming.CreateProductUseCase;
import com.example.petclinic.ports.incoming.ListProductsUseCase;
import com.example.petclinic.ports.outgoing.CreateProductPort;
import com.example.petclinic.ports.outgoing.ListProductsPort;

import java.util.List;

public record CreateProductFacade(CreateProductPort createProductPort) implements CreateProductUseCase {


    @Override
    public void execute(Command command) {
        createProductPort.create(new CreateProductPort.Product(command.name()));
    }
}
