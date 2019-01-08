package se.claudiastenberg.TestKotlin.repository.data

import com.fasterxml.jackson.annotation.JsonManagedReference
import javax.persistence.*

/** Data class. För att endast "hålla" i data.
 * Kotlin förser oss då med equals metod och toString metod bland annat.
 *
 * Man kan antingen deklarera varabler med var eller med val.
 * val (immutable, value) betyder att den då inte är konstant, den går alltså ej att ändra
* Data class sätter man när man vill att klassen agerar som en model
 * Val - immutable, förser en get metod. Denna kommer ej att ändras
 * Var - mutable, kan användas getter och setter. Denna kan komma att ändras
 * JAG använder val eftersom de i mitt fall ej behövs setta något.
 * */

@Entity
@Table(name = "Appointment")
data class Appointment(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                  val id: Long,
                  val cause: String? = null,
                       @OneToMany(mappedBy = "appointment", fetch = FetchType.EAGER)
                       @JsonManagedReference
                       val animal: Collection<Animal>? = null)

