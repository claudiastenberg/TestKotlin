package se.claudiastenberg.TestKotlin.repository.data

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*


@Entity
@Table(name = "Appointment")
data class Appointment(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long? = null,
                  var cause: String? = null,
                  @ManyToOne
                  @JsonBackReference
                  var animal: Animal? = null)