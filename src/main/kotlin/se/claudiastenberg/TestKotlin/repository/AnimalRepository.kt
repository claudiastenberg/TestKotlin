package se.claudiastenberg.TestKotlin.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import se.claudiastenberg.TestKotlin.repository.data.Animal

@Repository
interface AnimalRepository : JpaRepository<Animal, Long>