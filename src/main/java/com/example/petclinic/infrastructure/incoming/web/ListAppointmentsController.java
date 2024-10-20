package com.example.petclinic.infrastructure.incoming.web;

import com.example.petclinic.domain.port.incoming.AppointmentsView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
record ListAppointmentsController(AppointmentsView view) {

    @GetMapping("/admin/appointments")
    public Map<String, Object> get() {
        return Map.of("appointments", view.get());
    }
}
