package com.desciplineGrasser.demo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DisciplineRepository extends MongoRepository<Discipline, String> {
    // Add custom query methods if needed
    Discipline findByName(String name);
}