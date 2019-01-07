package se.claudiastenberg.TestKotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import se.claudiastenberg.TestKotlin.repository.data.Animal

@Repository
interface ARespository : JpaRepository<Animal, Long>

/** Detta är en file, inte en klass
 * I Kotlin behöver man ej ha samma namn på Interfave som på filen.
 * I Java skulle detta bli fel men inte i Kotlin
 * Man kan alltså addera flera saker i samma fil och använda olika metoder från andra klasser och dem behöver ej ha något att göra med filen dem ligger i.
 * */
