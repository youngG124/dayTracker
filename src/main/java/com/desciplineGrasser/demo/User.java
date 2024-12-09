package com.desciplineGrasser.demo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "days")
public class User {
    @Id
    private String id;
    private String name;
    private String email;

    // Getters and setters
}