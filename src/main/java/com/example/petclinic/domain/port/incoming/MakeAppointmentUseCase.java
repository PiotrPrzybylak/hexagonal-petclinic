package com.example.petclinic.domain.port.incoming;

import java.time.LocalDateTime;

public interface MakeAppointmentUseCase {

    void execute(Command command);

    record Command(LocalDateTime time, String customerName) {
    }
}
