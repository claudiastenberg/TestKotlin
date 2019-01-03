package se.claudiastenberg.TestKotlin.repository.data

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

@Entity
@Table(name = "Animal")
data class Animal(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long? = null,
                  var name: String,
                  var ras: String,
                  var age: Int,
                  @ManyToOne
                  @JsonBackReference
                  var appointment: Appointment? = null)
                 /*@OneToMany(mappedBy = "animal", fetch = FetchType.EAGER)
                  @JsonManagedReference
                  var appointment: Collection<Appointment>? = null)*/

/*Man kan antingen deklarera varabler med var eller med val. val betyder att den då inte är konstant, den går alltså ej att ändra
* Data class sätter man när man vill att klassen agerar som en model */