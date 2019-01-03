package se.claudiastenberg.TestKotlin.repository.data

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.*

@Entity
@Table(name = "Animal")
data class Animal(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long? = null,
                  var title: String? = null,
                  var ras: String? = null,
                  var age: Int? = null,
                  @OneToMany(mappedBy = "animal", fetch = FetchType.EAGER)
                  @JsonManagedReference
                  var appointment: Collection<Appointment>? = null)
