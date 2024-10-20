package com.example.petclinic.domain.port.outgoing;

import java.time.LocalDateTime;
import java.util.List;

public interface ListAppointmentsPort {

    List<Appointment> list();

    record Appointment(LocalDateTime time, String customerName) {
    }
}
