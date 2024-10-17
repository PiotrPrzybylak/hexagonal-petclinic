package com.example.petclinic.infrastructure.incoming.web;

import com.example.petclinic.domain.port.incoming.ReturnProductUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
record ReturnProductController(ReturnProductUseCase useCase) {

    @PostMapping("/return")
    public String returnProduct(String name) {
        useCase.execute(new ReturnProductUseCase.Command(name));
        return "redirect:/product_list";
    }

}
