package com.example.petclinic.domain.logic.appointment;

import com.example.petclinic.domain.port.incoming.AppointmentsView;
import com.example.petclinic.domain.port.outgoing.ListAppointmentsPort;

import java.util.List;

public record AppointmentsViewFacade(ListAppointmentsPort port) implements AppointmentsView {
    @Override
    public List<Appointment> get() {
        return port.list().stream().map(appointment -> new Appointment(appointment.time(), appointment.customerName())).toList();
    }
}
