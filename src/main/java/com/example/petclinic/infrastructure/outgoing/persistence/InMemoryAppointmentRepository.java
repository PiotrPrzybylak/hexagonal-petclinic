package com.example.petclinic.infrastructure.outgoing.persistence;

import com.example.petclinic.domain.port.outgoing.CreateAppointmentPort;
import com.example.petclinic.domain.port.outgoing.ListAppointmentsPort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
class InMemoryAppointmentRepository implements CreateAppointmentPort, ListAppointmentsPort {

    private final List<Appointment> appointments = new ArrayList<>();

    @Override
    public void create(LocalDateTime time, String customerName) {
        appointments.add(new Appointment(time, customerName));
    }

    @Override
    public List<Appointment> list() {
        return List.copyOf(appointments);
    }
}
