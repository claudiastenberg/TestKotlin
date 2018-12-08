package se.claudiastenberg.TestKotlin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.claudiastenberg.TestKotlin.repository.data.Animal;
import se.claudiastenberg.TestKotlin.repository.AnimalRepository;

@Service
public class AnimalService {
        @Autowired
        private final AnimalRepository repository;

        public AnimalService(AnimalRepository repository) {
            this.repository = repository;
        }
        /*Create a Animal*/
        public Animal createUser(Animal user){
            return repository.save(user);
        }
        /*Get all Animals*/
        public Iterable<Animal> getallUsers() {
            return repository.findAll();
        }
}
