package se.claudiastenberg.TestKotlin.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import se.claudiastenberg.TestKotlin.repository.data.Appointment

@Repository
interface AppointmentRepository : CrudRepository<Appointment, Long>