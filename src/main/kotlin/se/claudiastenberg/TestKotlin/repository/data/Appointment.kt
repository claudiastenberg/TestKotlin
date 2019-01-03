package se.claudiastenberg.TestKotlin.repository.data

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*


@Entity
@Table(name = "Appointment")
data class Appointment(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long? = null,
                  var cause: String? = null,
                       @OneToMany(mappedBy = "appointment", fetch = FetchType.EAGER)
                       @JsonManagedReference
                       var animal: Collection<Animal>? = null)

/*@ManyToOne
@JsonBackReference
var animal: Animal? = null*/