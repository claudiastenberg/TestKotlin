package se.claudiastenberg.TestKotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.claudiastenberg.TestKotlin.repository.ARespository
import se.claudiastenberg.TestKotlin.repository.data.Animal
import se.claudiastenberg.TestKotlin.repository.AnimalRepository
import java.util.*

@Service
class AnimalService(@field:Autowired
                    private val repository: AnimalRepository) { //Funkar även att ha ARepository

    fun createClient(client: Animal): Animal {
        return repository.save(client)
    }

    fun getallClient(): Iterable<Animal> {
        return repository.findAll()
    }

    fun getClient(clientId: Long?): Animal {
        val client = repository.findById(clientId!!)
            return client.get()
    }

    fun updateUser(clientId: Long?, client: Animal): Optional<Animal>? {
        return repository.findById(clientId!!).map { (id, name, ras, age, appointment) -> repository.save(client) }
    } /*clientId!! betyder att den är NullPointerException säker. Om clientId är null kommer den att kasta ett NPE annars kommer den att hitta ID.*/

    fun deleteUser(clientId: Long?) {
        val client = repository.findById(clientId!!)
        repository.delete(client.get())
    }
}
/**
 * Om man har en variabel som man har deklarerat i data klassen att den kan vara null.
 * DÅ sätter man ett ? eller !! för variabeln för att varna kotlin att detta kan vara null och isåfall behöver den ej kasta ett exception
 * utan bara skriva ut null isåfall
 * */