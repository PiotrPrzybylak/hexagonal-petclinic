package com.example.petclinic.domain.logic.product;

import com.example.petclinic.domain.port.outgoing.ProductBoughtNotifier;
import com.example.petclinic.domain.port.outgoing.UpdateProductPort;

class Product {

    private String name;
    private int quantity;
    private ProductBoughtNotifier productBoughtNotifier;
    private UpdateProductPort updateProductPort;

    public Product(String name, int quantity, ProductBoughtNotifier productBoughtNotifier, UpdateProductPort updateProductPort) {
        this.name = name;
        this.quantity = quantity;
        this.productBoughtNotifier = productBoughtNotifier;
        this.updateProductPort = updateProductPort;
    }

    public void buy() {
        if (quantity > 0) {
            quantity--;
            productBoughtNotifier.notify(new ProductBoughtNotifier.Product(name));
            updateProductPort.update(new UpdateProductPort.Product(name, quantity));
        }
    }

    public void returnProduct() {
        quantity++;
        updateProductPort.update(new UpdateProductPort.Product(name, quantity));
    }
}
