package com.example.petclinic.domain.logic.product;

import com.example.petclinic.domain.port.incoming.ReturnProductUseCase;
import com.example.petclinic.domain.port.outgoing.FindProductPort;
import com.example.petclinic.domain.port.outgoing.ProductBoughtNotifier;
import com.example.petclinic.domain.port.outgoing.UpdateProductPort;

import java.util.Optional;

public record ReturnProductFacade(FindProductPort findProductPort, UpdateProductPort updateProductPort, ProductBoughtNotifier productBoughtNotifier) implements ReturnProductUseCase {
    @Override
    public void execute(Command command) {
        Optional<FindProductPort.Product> maybeProduct = findProductPort.findByName(command.name());
        maybeProduct.ifPresent( p -> {
            Product product = new Product(p.name(), p.quantity(), productBoughtNotifier, updateProductPort);
            product.returnProduct();
        });

    }
}
