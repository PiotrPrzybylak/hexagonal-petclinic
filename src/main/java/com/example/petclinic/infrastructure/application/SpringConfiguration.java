package com.example.petclinic.infrastructure.application;

import com.example.petclinic.domain.logic.product.BuyProductFacade;
import com.example.petclinic.domain.logic.product.CreateProductFacade;
import com.example.petclinic.domain.logic.product.ListProductsFacade;
import com.example.petclinic.domain.logic.product.ReturnProductFacade;
import com.example.petclinic.domain.port.incoming.BuyProductUseCase;
import com.example.petclinic.domain.port.incoming.CreateProductUseCase;
import com.example.petclinic.domain.port.incoming.ListProductsUseCase;
import com.example.petclinic.domain.port.incoming.ReturnProductUseCase;
import com.example.petclinic.domain.port.outgoing.CreateProductPort;
import com.example.petclinic.domain.port.outgoing.FindProductPort;
import com.example.petclinic.domain.port.outgoing.ListProductsPort;
import com.example.petclinic.domain.port.outgoing.ProductBoughtNotifier;
import com.example.petclinic.domain.port.outgoing.UpdateProductPort;
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

    @Bean
    ReturnProductUseCase returnProductUseCase(FindProductPort findProductPort, UpdateProductPort updateProductPort, ProductBoughtNotifier productBoughtNotifier) {
        return new ReturnProductFacade(findProductPort, updateProductPort, productBoughtNotifier);
    }
}
