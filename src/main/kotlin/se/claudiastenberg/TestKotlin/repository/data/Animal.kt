package se.claudiastenberg.TestKotlin.repository.data

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

/** I detta fall använder vi BARA en primär konstruktor (Define-In line, Inget "new" keyword)
 * Vi behöver varken en separat konstruktor som säger this.name ex som i Java
 * Vi behöver inte heller en tom konstruktor som behövs i java för att de ej ska bli kompileringsfel vid anvädning av jersey.
 * Man kan även skapa proppertoes i klassen, alltså variabler i klassen. MEN dessa kan man då ej använda getter o setter till.
 * */

@Entity
@Table(name = "Animal")
data class Animal(@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
                  var id: Long? = null, /** Denna ? säger alltså att detta kan vara null*/
                  var name: String,
                  var ras: String,
                  var age: Int,
                  @ManyToOne
                  @JsonBackReference
                  var appointment: Appointment? = null)