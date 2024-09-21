package com.example.petclinic.domain.logic.product;

import com.example.petclinic.domain.port.incoming.ReturnProductUseCase;
import com.example.petclinic.domain.port.outgoing.FindProductPort;
import com.example.petclinic.domain.port.outgoing.UpdateProductPort;

import java.util.Optional;

public record ReturnProductFacade(FindProductPort findProductPort, UpdateProductPort updateProductPort) implements ReturnProductUseCase {
    @Override
    public void execute(Command command) {
        Optional<FindProductPort.Product> maybeProduct = findProductPort.findByName(command.name());
        maybeProduct.ifPresent( product -> {
            int quantity = product.quantity();
            quantity++;
            updateProductPort.update(new UpdateProductPort.Product(product.name(), quantity));
        });

    }
}
