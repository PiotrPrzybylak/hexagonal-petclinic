package com.example.petclinic.infrastructure.application;

import com.example.petclinic.domain.product.BuyProductFacade;
import com.example.petclinic.domain.product.CreateProductFacade;
import com.example.petclinic.domain.product.ListProductsFacade;
import com.example.petclinic.ports.incoming.BuyProductUseCase;
import com.example.petclinic.ports.incoming.CreateProductUseCase;
import com.example.petclinic.ports.incoming.ListProductsUseCase;
import com.example.petclinic.ports.outgoing.CreateProductPort;
import com.example.petclinic.ports.outgoing.FindProductPort;
import com.example.petclinic.ports.outgoing.ListProductsPort;
import com.example.petclinic.ports.outgoing.ProductBoughtNotifier;
import com.example.petclinic.ports.outgoing.UpdateProductPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringConfiguration {

    @Bean
    ListProductsUseCase listProductsUseCase(ListProductsPort port) {
        return new ListProductsFacade(port);
    }

    @Bean
    CreateProductUseCase createProductUseCase(CreateProductPort port) {
        return new CreateProductFacade(port);
    }

    @Bean
    BuyProductUseCase buyProductUseCase(FindProductPort findProductPort, UpdateProductPort updateProductPort, ProductBoughtNotifier productBoughtNotifier) {
        return new BuyProductFacade(findProductPort, updateProductPort, productBoughtNotifier);
    }
}
