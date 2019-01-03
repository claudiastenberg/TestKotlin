package se.claudiastenberg.TestKotlin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.claudiastenberg.TestKotlin.repository.AppointmentRepository;
import se.claudiastenberg.TestKotlin.repository.data.Appointment;

import javax.ws.rs.NotFoundException;
import java.util.Optional;

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
    public Iterable<Appointment> getallAppoinments() {
        return repository.findAll();
    }
   /* public Optional<Appointment> getAppoinment(Long appoinmentId){
      return  repository.findById(appoinmentId);
    }*/
    /*upadte*/
    public Appointment updateAppoinment(Long appoinmentId, Appointment appointment) {
        return repository.findById(appoinmentId).map(appointment1 ->repository.save(appointment))
                .orElseThrow(() -> new NotFoundException(String.
                        format("Finns iingen bokad tid med detta Id!", appoinmentId)));

    }
    /*delete*/
    public void deleteAppoiment(Long appoinmentId){
        Optional<Appointment> appointment = repository.findById(appoinmentId);
        if (!appointment.isPresent()){
            throw new NotFoundException("Finns ingen bokad tid med detta Id");
        }
        repository.delete(appointment.get());
    }

}
