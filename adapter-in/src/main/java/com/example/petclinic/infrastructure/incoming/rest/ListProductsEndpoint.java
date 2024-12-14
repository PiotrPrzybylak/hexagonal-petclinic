package com.example.petclinic.infrastructure.incoming.rest;

import com.example.petclinic.domain.port.incoming.ListProductsUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
record ListProductsEndpoint(ListProductsUseCase useCase) {

    @GetMapping("/api/products")
    public List<ListProductsUseCase.Product> get() {
        return useCase.list();
    }
}
