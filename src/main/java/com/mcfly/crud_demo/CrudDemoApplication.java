package com.mcfly.crud_demo;

import com.mcfly.crud_demo.dao.StudentDAO;
import com.mcfly.crud_demo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	// CommandLineRunner is executed after the Spring Beans have been loaded.
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> createStudent(studentDAO);
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		final Student student = new Student("Paul", "Doe", "paul@mcfly.com");
		System.out.println("Saving the student...");
		studentDAO.save(student);
		System.out.println("Saved student. Generated id: " + student.getId());
	}
}
