package com.example.petclinic.infrastructure.application;

import com.example.petclinic.domain.product.CreateProductFacade;
import com.example.petclinic.domain.product.ListProductsFacade;
import com.example.petclinic.ports.incoming.CreateProductUseCase;
import com.example.petclinic.ports.incoming.ListProductsUseCase;
import com.example.petclinic.ports.outgoing.CreateProductPort;
import com.example.petclinic.ports.outgoing.ListProductsPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringConfiguration {

    @Bean
    ListProductsUseCase getListProductsUseCase(ListProductsPort port) {
        return new ListProductsFacade(port);
    }

    @Bean
    CreateProductUseCase getCreateProductUseCase(CreateProductPort port) {
        return new CreateProductFacade(port);
    }
}
