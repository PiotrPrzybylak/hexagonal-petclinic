package com.example.petclinic.infrastructure.incoming.web;

import com.example.petclinic.ports.incoming.ListProductsUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
record ListProductsController(ListProductsUseCase useCase) {

    @GetMapping("/product_list")
    public Map<String, Object> get() {
        return Map.of("products", useCase.list());
    }
}
