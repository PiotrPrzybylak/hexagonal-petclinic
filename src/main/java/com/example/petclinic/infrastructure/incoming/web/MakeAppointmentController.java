package com.example.petclinic.infrastructure.incoming.web;

import com.example.petclinic.domain.port.incoming.CreateProductUseCase;
import com.example.petclinic.domain.port.incoming.MakeAppointmentUseCase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
record MakeAppointmentController(MakeAppointmentUseCase useCase) {

    @GetMapping("/make_appointment")
    public void form() {
    }

    @PostMapping("/make_appointment")
    public String create(String name, LocalDateTime time) {
        useCase.execute(new MakeAppointmentUseCase.Command(time, name));
        return "redirect:/appointment_made.html";
    }

}
