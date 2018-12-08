package se.claudiastenberg.TestKotlin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.claudiastenberg.TestKotlin.repository.AppointmentRepository;
import se.claudiastenberg.TestKotlin.repository.data.Appointment;

@Service
public class AppoinmentService {
    @Autowired
    private final AppointmentRepository repository;

    public AppoinmentService(AppointmentRepository repository) {
        this.repository = repository;
    }
    /*Create a Animal*/
    public Appointment bookAppoinment(Appointment appointment){
        return repository.save(appointment);
    }
    /*Get all Animals*/
    public Iterable<Appointment> getallBookings() {
        return repository.findAll();
    }
}
