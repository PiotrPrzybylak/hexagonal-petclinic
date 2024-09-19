package com.example.petclinic.infrastructure.outgoing.console;

import com.example.petclinic.ports.outgoing.ProductBoughtNotifier;
import org.springframework.stereotype.Component;

@Component
public class ConsoleProductBoughtNotifier implements ProductBoughtNotifier {
    @Override
    public void notify(Product product) {
        System.out.println("Product bought: " + product);
    }
}
