package com.example.petclinic.domain.logic.product;

import com.example.petclinic.domain.port.incoming.BuyProductUseCase;
import com.example.petclinic.domain.port.outgoing.FindProductPort;
import com.example.petclinic.domain.port.outgoing.ProductBoughtNotifier;
import com.example.petclinic.domain.port.outgoing.UpdateProductPort;

import java.util.Optional;

public record BuyProductFacade(FindProductPort findProductPort, UpdateProductPort updateProductPort,
                               ProductBoughtNotifier productBoughtNotifier) implements BuyProductUseCase {


    @Override
    public void execute(Command command) {
        Optional<FindProductPort.Product> maybeProduct = findProductPort.findByName(command.name());
        maybeProduct.ifPresent(foundProduct -> {
            Product product = new Product(foundProduct.name(), foundProduct.quantity(), productBoughtNotifier);
            product.buy();
            updateProductPort.update(new UpdateProductPort.Product(foundProduct.name(), product.getQuantity()));
        });
    }
}
