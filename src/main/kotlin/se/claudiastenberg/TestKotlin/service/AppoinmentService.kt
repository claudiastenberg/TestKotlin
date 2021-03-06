package se.claudiastenberg.TestKotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.claudiastenberg.TestKotlin.repository.AppointmentRepository
import se.claudiastenberg.TestKotlin.repository.data.Appointment
import java.util.*

import javax.ws.rs.NotFoundException

@Service
class AppoinmentService(@field:Autowired
                        private val repository: AppointmentRepository) {

    fun bookAppoinment(appointment: Appointment): Appointment {
        return repository.save(appointment)
    }

    fun getallAppoinments(): Iterable<Appointment> {
        return repository.findAll()
    }

     fun getAppoinment(appoinmentId: Long): Optional<Appointment> {
         return repository.findById(appoinmentId)
     }

    fun updateAppoinment(appoinmentId: Long, appointment: Appointment): Optional<Appointment> {
        /** if(appoinmentId != null){} OM vi skulle vilja göra såhär som vi är vana med i Java så hjälper IDE att säga "Condition is always true",
         med andra ord att detta ej nödvändigt i Kotlin.
        */
        return repository.findById(appoinmentId).map { repository.save(appointment) }
    }

    fun deleteAppoiment(appoinmentId: Long) {
        val appointment = repository.findById(appoinmentId)
        repository.delete(appointment.get())
    }
}
