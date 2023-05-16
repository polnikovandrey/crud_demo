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
		return runner -> {
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		final Student student = new Student("Paul", "Doe", "paul@mcfly.com");
		System.out.println("Saving the student...");
		studentDAO.save(student);
		System.out.println("Saved student. Generated id: " + student.getId());
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("Creating 3 student objects...");
		final Student student1 = new Student("John", "Doe", "john@mcfly.com");
		final Student student2 = new Student("Mary", "Christmas", "mary@mcfly.com");
		final Student student3 = new Student("Bonita", "Vita", "bonita@mcfly.com");
		System.out.println("Saving the students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);
		System.out.println("Saved student. Generated id: " + student1.getId());
		System.out.println("Saved student. Generated id: " + student2.getId());
		System.out.println("Saved student. Generated id: " + student3.getId());
	}
}
