package com.example.petclinic.domain.port.outgoing;

import java.time.LocalDateTime;

public interface CreateAppointmentPort {
    void create(LocalDateTime time, String customerName);
}
