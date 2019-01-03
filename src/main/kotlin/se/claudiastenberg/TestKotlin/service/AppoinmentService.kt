package se.claudiastenberg.TestKotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.claudiastenberg.TestKotlin.repository.AppointmentRepository
import se.claudiastenberg.TestKotlin.repository.data.Appointment

import javax.ws.rs.NotFoundException

@Service
class AppoinmentService(@field:Autowired
                        private val repository: AppointmentRepository) {
    /*Create a Animal*/
    fun bookAppoinment(appointment: Appointment): Appointment {
        return repository.save(appointment)
    }

    /*Get all Animals*/
    fun getallAppoinments(): Iterable<Appointment> {
        return repository.findAll()
    }

    /* public Optional<Appointment> getAppoinment(Long appoinmentId){
      return  repository.findById(appoinmentId);
    }*/
    /*upadte*/
    fun updateAppoinment(appoinmentId: Long?, appointment: Appointment): Appointment {
        return repository.findById(appoinmentId!!).map { (id, cause, animal) -> repository.save(appointment) }
                .orElseThrow { NotFoundException(String.format("Finns iingen bokad tid med detta Id!", appoinmentId)) }

    }

    /*delete*/
    fun deleteAppoiment(appoinmentId: Long?) {
        val appointment = repository.findById(appoinmentId!!)
        if (!appointment.isPresent) {
            throw NotFoundException("Finns ingen bokad tid med detta Id")
        }
        repository.delete(appointment.get())
    }

}
