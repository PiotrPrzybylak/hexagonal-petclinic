package com.example.petclinic.domain.port.incoming;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentsView {

    List<Appointment> get();

    record Appointment(LocalDateTime time, String customerName) {
    }
}
