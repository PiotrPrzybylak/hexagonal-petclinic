package com.example.petclinic.infrastructure.incoming.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class IndexController {

    @GetMapping({"/"})
    public String home() {
        return "redirect:/product_list";
    }
}
