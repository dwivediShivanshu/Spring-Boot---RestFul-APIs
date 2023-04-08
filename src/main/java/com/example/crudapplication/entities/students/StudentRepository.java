package com.example.crudapplication.entities.students;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
    Optional<Student> findStudentByFirstName(String firstName);
}