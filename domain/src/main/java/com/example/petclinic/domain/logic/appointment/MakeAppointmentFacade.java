package com.example.petclinic.domain.logic.appointment;

import com.example.petclinic.domain.port.incoming.MakeAppointmentUseCase;
import com.example.petclinic.domain.port.outgoing.CreateAppointmentPort;

public record MakeAppointmentFacade(CreateAppointmentPort port) implements MakeAppointmentUseCase {

    @Override
    public void execute(Command command) {
        port.create(command.time(), command.customerName());
    }
}
