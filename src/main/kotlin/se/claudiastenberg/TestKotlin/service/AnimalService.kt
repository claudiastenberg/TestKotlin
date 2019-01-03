package se.claudiastenberg.TestKotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import se.claudiastenberg.TestKotlin.repository.data.Animal
import se.claudiastenberg.TestKotlin.repository.AnimalRepository

import javax.ws.rs.NotFoundException

@Service
class AnimalService(@field:Autowired
                    private val repository: AnimalRepository) {

    /*Create a Animal*/
    fun createUser(user: Animal): Animal {
        return repository.save(user)
    }

    /*Get all Animals*/
    fun getallUsers(): Iterable<Animal> {
        return repository.findAll()
    }

    fun getUser(animalId: Long?): Animal {
        val animal = repository.findById(animalId!!)
        if (animal.isPresent) {
            return animal.get()
        }
        throw se.claudiastenberg.TestKotlin.service.exception.NotFoundException("Finns inget djur med detta Id!")
    }

    /*upadte*/
    fun updateUser(animalId: Long?, animal: Animal): Animal {
        return repository.findById(animalId!!).map { (id, title, ras, age, appointment) -> repository.save(animal) }
                .orElseThrow { se.claudiastenberg.TestKotlin.service.exception.NotFoundException(String.format("Finns inget djur med detta Id!", animalId)) }

    }

    /*delete*/
    fun deleteUser(animalId: Long?) {
        val animal = repository.findById(animalId!!)
        if (!animal.isPresent) {
            throw se.claudiastenberg.TestKotlin.service.exception.NotFoundException("Finns inget djur med detta Id")
        }
        repository.delete(animal.get())
    }
}
