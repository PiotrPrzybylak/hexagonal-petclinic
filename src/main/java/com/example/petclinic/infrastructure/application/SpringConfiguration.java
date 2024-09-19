package com.example.petclinic.infrastructure.application;

import com.example.petclinic.domain.product.ListProductsFacade;
import com.example.petclinic.ports.incoming.ListProductsUseCase;
import com.example.petclinic.ports.outgoing.ListProductsPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class SpringConfiguration {

    @Bean
    ListProductsUseCase getListProductsUseCase(ListProductsPort listProductsPort) {
        return new ListProductsFacade(listProductsPort);
    }
}
