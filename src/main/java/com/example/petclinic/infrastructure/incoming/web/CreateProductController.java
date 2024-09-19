package com.example.petclinic.infrastructure.incoming.web;

import com.example.petclinic.ports.incoming.CreateProductUseCase;
import com.example.petclinic.ports.incoming.ListProductsUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
record CreateProductController(CreateProductUseCase useCase) {

    @GetMapping("/create_product")
    public void form() {
    }

    @PostMapping("/create_product")
    public String create(String name) {
        useCase.execute(new CreateProductUseCase.Command(name));
        return "redirect:/product_list";
    }

}
