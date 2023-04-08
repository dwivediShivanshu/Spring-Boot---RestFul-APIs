package com.example.crudapplication.entities.students;

import java.util.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

// This annotation 
@Data
@Document(collection = "students")
public class Student {

    @Id
    private String id;
    @Indexed(unique = true)
    private String firstName;
    private String lastName;
    private Address address;
    private List<String> favSubjects;
    private Date created_at;
    private String gender;

    public Student(String firstName, String lastName, Address address, List<String> favSubjects, Date created_at,
            String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.favSubjects = favSubjects;
        this.created_at = created_at;
        this.gender = gender;
    }

}
