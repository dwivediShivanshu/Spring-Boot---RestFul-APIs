package com.example.crudapplication;

import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.crudapplication.entities.students.Address;
import com.example.crudapplication.entities.students.Student;
import com.example.crudapplication.entities.students.StudentRepository;

@SpringBootApplication
public class CrudapplicationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudapplicationApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository) {
		return args -> {
			Address address = new Address(
					"India",
					"Atlanta",
					"30318"

			);

			Student student = new Student(
					"RK",
					"Dwivedi",
					address,
					List.of("Material Science", "physics"),
					new Date(),
					"male");

			// repository.insert(student);
			repository.findStudentByFirstName("RK")
					.ifPresentOrElse(s -> {
						System.out.println(s + " already axists");
					}, () -> {
						System.out.println("Does not exists. So adding into DB");
						repository.insert(student);
					});

		};
	}

}
