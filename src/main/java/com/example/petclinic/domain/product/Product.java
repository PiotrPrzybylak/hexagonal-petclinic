package com.example.petclinic.domain.product;

import com.example.petclinic.ports.outgoing.ProductBoughtNotifier;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Product {

    private String name;
    private int quantity;
    private ProductBoughtNotifier productBoughtNotifier;

    public void buy() {
        if (quantity > 0) {
            quantity--;
            productBoughtNotifier.notify(new ProductBoughtNotifier.Product(name));
        }
    }
}