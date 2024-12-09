package com.desciplineGrasser.demo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    // Add custom query methods if needed
}