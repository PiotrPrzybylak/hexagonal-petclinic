package com.example.petclinic.infrastructure.outgoing.persistence;

import com.example.petclinic.domain.port.outgoing.CreateAppointmentPort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
class InMemoryAppointmentRepository implements CreateAppointmentPort {
    @Override
    public void create(LocalDateTime time, String customerName) {
        System.out.printf("New appointment for %s at %s%n", customerName, time);
    }
}
