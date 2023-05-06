package com.kushal.SringCrud;

import com.kushal.SringCrud.dao.StudentDAO;
import com.kushal.SringCrud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			System.out.println("Inside Command Line Runner");
			//createStudent(studentDAO);
			createMultipleStudents(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all Students");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : "+numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int stuId = 5;
		System.out.println("Deleting student with id "+stuId);
		studentDAO.delete(stuId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int stuId = 1;
		System.out.println("Getting student with id "+stuId);
		Student myStudent = studentDAO.findById(stuId);
		myStudent.setFirstName("Kushal");
		studentDAO.update(myStudent);
		System.out.println("Updated Student "+studentDAO.findById(stuId));
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> ss = studentDAO.findByLastName("sharma");
		System.out.println("Found all Students by lastName");
		for(Student s: ss){
			System.out.println(s);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> ss = studentDAO.findAll();
		System.out.println("Found all Students");
		for(Student s: ss){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Student stu = new Student("mikey", "mouse", "mickey.mouse@gmail.com");
		studentDAO.save(stu);
		System.out.println(" Student Saved : "+stu.getId());
		Student stu1 = studentDAO.findById(stu.getId());
		System.out.println("Student Retrieved : "+stu1);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		Student student1 = new Student("kush", "sharma", "kushal.sha@gmail.com");
		Student student2 = new Student("kamal", "shri", "kamal.shri@gmail.com");
		Student student3 = new Student("aditya", "jain", "aditya.jain@gmail.com");
		System.out.println("Saving multiple students...");
		studentDAO.save(student1);
		studentDAO.save(student2);
		studentDAO.save(student3);

	}

	private void createStudent(StudentDAO studentDAO) {
		//create student Obj
		System.out.println("Creating Student");
		Student student = new Student("kushal", "sharma", "kush.sha@gmail.com");
		//save
		System.out.println("Saving Student");
		studentDAO.save(student);
		//display id of saved student
		System.out.println("Saved Student "+student.getId());
	}
}
