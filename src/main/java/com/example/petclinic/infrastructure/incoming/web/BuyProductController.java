package com.example.petclinic.infrastructure.incoming.web;

import com.example.petclinic.ports.incoming.BuyProductUseCase;
import com.example.petclinic.ports.incoming.CreateProductUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
record BuyProductController(BuyProductUseCase useCase) {

    @PostMapping("/buy")
    public String buy(String name) {
        useCase.execute(new BuyProductUseCase.Command(name));
        return "redirect:/product_list";
    }

}
