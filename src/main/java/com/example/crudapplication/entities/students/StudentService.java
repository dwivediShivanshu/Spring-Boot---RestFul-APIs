package com.example.crudapplication.entities.students;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Optional<Student> getStudent(String fName) {
        return studentRepository.findStudentByFirstName(fName);
    }

    public Student saveStudent(Student student) {
        return studentRepository.insert(student);
    }
}
